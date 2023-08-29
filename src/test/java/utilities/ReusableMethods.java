package utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.HashMap;
import java.util.List;

public class ReusableMethods {

    public static HashMap<String, String> convertDataTable(DataTable table) {
        HashMap<String, String> entities = new HashMap<>();
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows){
            entities.put(columns.get(0), columns.get(1));
        }
        return entities;
    }
}
