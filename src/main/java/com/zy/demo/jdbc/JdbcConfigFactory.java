package com.zy.demo.jdbc;

import com.zy.demo.io.PropertiesReader;

public class JdbcConfigFactory {

    public static JdbcConfig getJdbcConfig(String databaseName) {
        PropertiesReader pr = PropertiesReader.getInstance();
        JdbcConfig jdbcConfig = new JdbcConfig();
        switch (databaseName) {
            case "mysql":
                jdbcConfig.setUrl(pr.getPropertiesValue("database.mysql.url"));
                jdbcConfig.setUsername(pr.getPropertiesValue("database.mysql.username"));
                jdbcConfig.setPassword(pr.getPropertiesValue("database.mysql.password"));
                break;
            case "oracle":
                jdbcConfig.setUrl(pr.getPropertiesValue("database.oracle.url"));
                jdbcConfig.setUsername(pr.getPropertiesValue("database.oracle.username"));
                jdbcConfig.setPassword(pr.getPropertiesValue("database.oracle.password"));
                break;
            default:
                jdbcConfig = null;
                break;
        }
        return jdbcConfig;
    }
}
