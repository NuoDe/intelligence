package com.nuode.intelligence.modular.system.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:34
 */

public class PropertiesUtil {
    private static String MYSQL_CONFIG_PATH = System.getProperty("user.dir") + "/src/main/resources/application.properties";

    public PropertiesUtil(String MYSQL_CONFIG_PATH){
        this.MYSQL_CONFIG_PATH = MYSQL_CONFIG_PATH;
    }

    public static boolean initProperties(Object object) {

        File configFile = new File(MYSQL_CONFIG_PATH);

        FileInputStream configInputStresm = null;
        try {
            configInputStresm = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try {
            properties.load(configInputStresm);

            Map map = ObjectUtils.objectToMap(object);
            map.get("driverClassName");
            Map hash = new HashMap();
            hash.put("a","1");
            hash.put("b","2");
            System.out.println("map:" + map + ",当前方法:PropertiesUtil.initProperties()");
            System.out.println("hash:" + hash + ",当前方法:PropertiesUtil.initProperties()");
            properties.putAll(map);

            FileOutputStream outputStream = new FileOutputStream(configFile);

            properties.store(outputStream, null);

            outputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
