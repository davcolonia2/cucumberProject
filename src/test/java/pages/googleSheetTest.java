package pages;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class googleSheetTest {


    private static final String APPLICATION_NAME = "My Project 57998";
    private static final String SPREADSHEET_ID = "15oNeO_lPgqjnnGzxGoj4yaZlI381RMpJrmWdP9xPTDQ";
    private static final String RANGE = "Sheet1!A1:C"; // Adjust range as needed
    private static Sheets sheetsService;

    public static void main(String[] args) throws GeneralSecurityException, IOException, InterruptedException {
        sheetsService = getSheetsService();
        List<List<Object>> data = getSpreadsheetData();

        WebDriver driver = new ChromeDriver();
        driver.get("https://agencyexcellenceawards.withgoogle.com/intl/en_us");
        Thread.sleep(4000);

        for (int i = 0; i < data.size(); i++) {
            List<Object> row = data.get(i);
            String textToCheck = row.size() > 0 ? row.get(0).toString().trim() : "";
            String result = "fail";
           if(!textToCheck.isEmpty()){
            boolean isTextFound = false;

            try {
                WebElement element1 = driver.findElement(By.xpath("//*[@id='homepage-content']/section/div/div[2]/p[contains(text(), '" + textToCheck + "')]"));
                if (element1 != null) {
                    isTextFound = true;
                }
            } catch (Exception e) {
                // Ignored
            }

            // Second XPath check
            try {
                WebElement element2 = driver.findElement(By.xpath("//*[@id='why-enter']/div/div[2]/ul[2]/li[3]/p[contains(text(), '" + textToCheck + "')]"));
                if (element2 != null) {
                    isTextFound = true;
                }
            } catch (Exception e) {
                // Ignored
            }

            if (isTextFound) {
                result = "pass";
            }
        }

//            if (textToCheck.isEmpty()) {
//                updateSpreadsheet(i + 1, "fail");
//                continue;
//            }
//            try {
//                WebElement element = driver.findElement(By.xpath( "//*[@id='homepage-content']/section/div/div[2]/p[contains(text(), '" + textToCheck + "')]"));
//                if (element != null) {
//                    updateSpreadsheet(i + 1, "pass");
//                } else {
//                    updateSpreadsheet(i + 1, "fail");
//                }
//            } catch (Exception e) {
//                updateSpreadsheet(i + 1, "fail");
//            }
        if (!textToCheck.isEmpty()) {
            updateSpreadsheet(i + 1, "C", result);
        }
    }

            driver.quit();
}



    private static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/test/resources/stream.json"))
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    private static List<List<Object>> getSpreadsheetData()throws IOException{
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID,RANGE)
                .execute();
        return response.getValues();
    }


    private static void updateSpreadsheet(int rowIndex,String column, String result) throws IOException {
        String cell = "C" + rowIndex; // Assuming the third column is for results
        ValueRange body = new ValueRange()
                .setValues(Collections.singletonList(Collections.singletonList(result)));
        sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, cell, body)
                .setValueInputOption("RAW")
                .execute();
    }

}
