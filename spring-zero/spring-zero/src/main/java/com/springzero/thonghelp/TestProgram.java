package com.springzero.thonghelp;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Hoang Thong
 *
 */
public class TestProgram {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DataTable dt = new DataTable();
        dt.addRow(0, "A", null);
        dt.addRow(1, "B", 0);
        dt.addRow(2, "C", 0);
        dt.addRow(3, "G", 0);
        dt.addRow(4, "D", 1);
        dt.addRow(5, "E", 1);
        dt.addRow(6, "F", 4);
        
        Map<String, List<String>> output = dt.processDataTable();
        
        for (Entry<String, List<String>> entry : output.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            } else {
                System.out.println(entry.getKey() + "=null");
            }
        }
    }
    
}
