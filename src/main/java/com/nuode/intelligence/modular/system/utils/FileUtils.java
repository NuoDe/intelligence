package com.nuode.intelligence.modular.system.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-10-18:07
 */
@UtilityClass
public class FileUtils {

    //静态文件存储路径
    private static final String UPLOAD_PATH = System.getProperty("user.dir") + "/src/main/resources/static/";

    private static final String NEW_FILE_NAME = "未命名";

    public String fileUpload(MultipartFile file){
        return fileUpload(file,null,null);
    }

    public String fileUpload(MultipartFile file, String namingRules,String uploadPath) {

        if(uploadPath.equals(null)){
            uploadPath = UPLOAD_PATH;
        }

        if(namingRules.equals(null)){
            namingRules = NEW_FILE_NAME;
        }
        switch (namingRules) {
            case "UUID":
                namingRules = UUID.randomUUID().toString();
                break;
            case "timeStamp":
                namingRules  =  Long.toString(new Date().getTime());
                break;
            default:
        }
        //文件后缀名
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        try {
            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(uploadPath+namingRules+suffixName)));
            return namingRules+suffixName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
