package com.HerreraCodes.FreebiesBackend.Service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component  // Tell Spring to manage this as a Singleton
public class ZipCodeEncoder {
    private Map<String, String> zipcodeMap;

    public ZipCodeEncoder() {
        zipcodeMap = new HashMap<>();
    }

    @PostConstruct  // This method runs after the bean is created
    private void loadZipcodes() {
        // Load the CSV file from the classpath
        Resource resource = new ClassPathResource("output.csv"); // Assuming it's in `src/main/resources`

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",", -1);
                if (parts.length >= 1) {
                    String zipcode = parts[0].trim();
                    String encodedZip = (parts.length > 1) ? parts[1].trim() : "";
                    if (!zipcode.isEmpty()) {
                        zipcodeMap.put(zipcode, encodedZip);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEncodedZip(String zipcode) {
        String encodedZip = zipcodeMap.get(zipcode.trim());
        return (encodedZip != null && !encodedZip.isEmpty()) ? encodedZip : null;
    }
}
