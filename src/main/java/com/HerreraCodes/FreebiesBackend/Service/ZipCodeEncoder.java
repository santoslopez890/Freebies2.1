package com.HerreraCodes.FreebiesBackend.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZipCodeEncoder {
    private static ZipCodeEncoder instance;
    private Map<String, String> zipcodeMap;

    private ZipCodeEncoder() {
        zipcodeMap = new HashMap<>();
        loadZipcodes();
    }

    public static synchronized ZipCodeEncoder getInstance() {
        if (instance == null) {
            instance = new ZipCodeEncoder();
        }
        return instance;
    }

    private void loadZipcodes() {
        String csvFile = "output.csv"; // <-- CHANGE THIS to your actual CSV path
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String zipcode = parts[0];
                    String encodedZip = parts.length > 1 ? parts[1] : "";
                    zipcodeMap.put(zipcode, encodedZip);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEncodedZip(String zipcode) {
        String encodedZip = zipcodeMap.get(zipcode);
        return (encodedZip != null && !encodedZip.isEmpty()) ? encodedZip : null;
    }
}

