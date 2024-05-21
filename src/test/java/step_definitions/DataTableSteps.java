package step_definitions;

import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTableSteps {
    @Given("this is a data table as a list")
    public void data_table_as_list(List<String>names){
        System.out.println("Given names: "+ names);
    }

    @Given("this is a data table as a map")
    public void data_table_as_map(Map<String,String>employee){
       System.out.println("Employee: "+ employee);
    }

    @Given("this is a data table as a list of lists")
    public void data_table_as_listsoflists(List<List<String>>employees){
        System.out.println("Initial form of List");
        for(List <String> employee:employees){
            System.out.println(employee);
        }

    }


    @Given("this is a data table as a list of maps")
    public void data_table_as_a_list_of_maps(List<Map<String,String>>employees){
        for(Map<String,String>employee:employees){
System.out.println(employee.get("first name"));
        }
    }
}
