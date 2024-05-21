package step_definitions;

import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dataStructures {
    public static void main(String [] args) {
        List<String> names1 = new ArrayList<>(List.of("Omar", "Ramo", "Jane"));
        System.out.println(names1);
        System.out.println(names1.get(0));
        List<String> lastNames = new ArrayList<>(List.of("Ramo", "Simpson", "Jefferson"));
        System.out.println(lastNames);
        System.out.println(lastNames.get(0));

        List<List<String>> listsCombined = new ArrayList<>(List.of(names1, lastNames));
        System.out.println(listsCombined);

        for (int i = 0; i < listsCombined.size(); i++) {
            for (int j = 0; j < listsCombined.size(); j++) {
                System.out.println(listsCombined.get(i).get(j));
            }
        }
//==
        for (List<String> temp : listsCombined) {
            System.out.println(temp.get(1));
        }
    }




    }

