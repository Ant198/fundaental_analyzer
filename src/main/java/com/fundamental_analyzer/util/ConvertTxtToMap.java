package com.fundamental_analyzer.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConvertTxtToMap {

    private static final String FILE_PATH = "src/main/java/com/fundamental_analyzer/resources/ticker.txt";    
    String line;
    public Map<String, String> convertTxtToMap() throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        try { BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s*→\\s*", 2);
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    map.put(key, value);
                } else {
                    System.out.println("ignoring line: " + line);
                }
            }
        }

        for (String key : map.keySet()) {
        System.out.println(key + ":" + map.get(key));
        }
        return map;
    }
}