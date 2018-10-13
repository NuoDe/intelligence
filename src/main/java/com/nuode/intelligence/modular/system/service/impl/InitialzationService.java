package com.nuode.intelligence.modular.system.service.impl;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import com.nuode.intelligence.modular.system.entity.SignInPage;
import com.nuode.intelligence.modular.system.mapper.InitialzationMapper;
import com.nuode.intelligence.modular.system.service.IInitialzationService;
import com.nuode.intelligence.modular.system.utils.ConnectionUtil;
import com.nuode.intelligence.modular.system.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:28
 */
@Service
@Transactional
public class InitialzationService implements IInitialzationService {

    @Autowired
    InitialzationMapper initialzationMapper;

    @Override
    public String dbInit(@RequestBody DBInitialzation dbInitialzation) {
        try {
            if (!ConnectionUtil.dbConnectionValidate(dbInitialzation.getUrl(), dbInitialzation.getUsername(), dbInitialzation.getPassword())) {
                return "error";
            }
            String mysqlConfigPath = System.getProperty("user.dir") + "/src/main/resources/application-mysql.properties";

            File configFile = new File(mysqlConfigPath);

            FileInputStream configInputStresm = null;
            try {
                configInputStresm = new FileInputStream(configFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Properties properties = new Properties();
            try {
                properties.load(configInputStresm);

                //properties.put("spring.datasource.driver-class-name",dbInitialzation.getDriverClassName());
                properties.put("spring.datasource.url",dbInitialzation.getUrl());
                properties.put("spring.datasource.username",dbInitialzation.getUsername());
                properties.put("spring.datasource.password",dbInitialzation.getPassword());

                FileOutputStream outputStream = new FileOutputStream(configFile);

                properties.store(outputStream, null);

                outputStream.close();

                initialzationMapper.createLoginPageTable();

                return "success";
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public boolean dbValidate(DBInitialzation DBInitialzation) {
        return ConnectionUtil.dbConnectionValidate(DBInitialzation.getUrl(), DBInitialzation.getUsername(), DBInitialzation.getPassword());
    }

    @Override
    public String setLogo(MultipartFile file) {
        //静态文件存储路径
        String mysqlConfigPath = System.getProperty("user.dir") + "/src/main/resources/static/";

        return FileUtils.fileUpload(file,"logo",mysqlConfigPath);
    }

    @Override
    public String setBackgroundImage(MultipartFile file) {
        //静态文件存储路径
        String mysqlConfigPath = System.getProperty("user.dir") + "/src/main/resources/static/";
        return FileUtils.fileUpload(file,"background",mysqlConfigPath);
    }

    @Override
    public boolean setCopyrightInfo(SignInPage signInPage) {
        signInPage.setCreateTime(String.valueOf(new Date().getTime()));
        int i = initialzationMapper.setLoginPageInfo(signInPage);
        return i!=0?true:false;
    }
}
