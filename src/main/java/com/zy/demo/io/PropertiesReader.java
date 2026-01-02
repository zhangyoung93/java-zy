package com.zy.demo.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件读取器
 *
 * @author zy
 */
public class PropertiesReader {

    private static final String PROPERTIES_FILE_NAME = "config.properties";

    private Properties properties;

    private static class PropertiesReaderInstance {
        private static final PropertiesReader PROPERTIES_READER = new PropertiesReader();
    }

    public static PropertiesReader getInstance() {
        return PropertiesReaderInstance.PROPERTIES_READER;
    }

    public String getPropertiesValue(String propertiesName) {
        if (this.properties == null) {
            Properties properties = new Properties();
            try (InputStream is = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)) {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.properties = properties;
        }
        String propertiesValue = this.properties.getProperty(propertiesName);
        System.out.println("read properties,name=" + propertiesName + ",value=" + propertiesValue);
        return propertiesValue;
    }
}
