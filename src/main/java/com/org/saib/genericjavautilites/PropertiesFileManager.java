package com.org.saib.genericjavautilites;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesFileManager {
    private Properties properties;
    private String filePath;

    public PropertiesFileManager(String filePath) {
        this.filePath = filePath;
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void saveProperties() {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    public void removeProperty(String key) {
        properties.remove(key);
    }
    
    public int getPropertyCount() {
        return properties.size();
    }
    
    public boolean containsProperty(String key) {
        return properties.containsKey(key);
    }
    
    public int getPropertyCountWithValues() {
        int count = 0;
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value != null && !value.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }
    
    public List<String> getPropertiesWithValues() {
        List<String> propertiesWithValues = new ArrayList<String>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value != null && !value.trim().isEmpty()) {
                propertiesWithValues.add(key + "=" + value);
            }
        }
        return propertiesWithValues;
    }
    
    public int getPropertyCountWithoutValues() {
        int count = 0;
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value == null || value.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }
    
    public List<String> getPropertiesWithoutValues() {
        List<String> propertiesWithoutValues = new ArrayList<String>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (value == null || value.trim().isEmpty()) {
                propertiesWithoutValues.add(key);
            }
        }
        return propertiesWithoutValues;
    }
    
}
