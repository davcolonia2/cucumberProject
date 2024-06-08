package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;
public static String getProperty(String key){
    String path = "src/test/resources/configs.properties";
try{
   properties= new Properties();
    FileInputStream fis = new FileInputStream(path);
    properties.load(fis);
    fis.close();
} catch (IOException e){
    e.printStackTrace();
}
return properties.getProperty(key);}



}
