package com.nuode.intelligence.modular.system.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-09-11:32
 */
public class ConnectionUtil {

    /**
     * 数据库连接测试方法
     * @param url
     * @param userName
     * @param password
     * @return
     */
    public static boolean dbConnectionValidate(String url, String userName, String password) {
        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }
    }
}
