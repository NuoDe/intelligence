package com.nuode.intelligence.modular.system.utils;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.Properties;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:34
 */

@UtilityClass
public class PropertiesUtil {

    private static final String MYSQL_CONFIG_PATH = System.getProperty("user.dir") + "/src/main/resources/application-mysql.properties";

    private static final File CONFIG_FILE = new File(MYSQL_CONFIG_PATH);

    private static FileInputStream CONFIG_FILE_INPUT_STRESM;

    static {
        try {
            CONFIG_FILE_INPUT_STRESM = new FileInputStream(CONFIG_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean initProperties(DBInitialzation DBInitialzation) {

        Properties properties = new Properties();

        if (ConnectionUtil.dbConnectionValidate(DBInitialzation.getUrl(), DBInitialzation.getUsername(), DBInitialzation.getPassword())) {

            try {
                properties.load(CONFIG_FILE_INPUT_STRESM);

                System.out.println("initialzation.getUrl():" + DBInitialzation.getUrl() + ",当前方法:PropertiesUtil.initProperties()");

                properties.put("spring.datasource.driver-class-name", "com.mysql.jdbc.Driver");
                properties.put("spring.datasource.url", DBInitialzation.getUrl());
                properties.put("spring.datasource.username", DBInitialzation.getUsername());
                properties.put("spring.datasource.password", DBInitialzation.getPassword());

                FileOutputStream outputStream = new FileOutputStream(CONFIG_FILE);

                properties.store(outputStream, null);

                outputStream.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
}
