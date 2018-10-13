package com.nuode.intelligence.modular.system.controller;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import com.nuode.intelligence.modular.system.entity.SignInPage;
import com.nuode.intelligence.modular.system.service.IInitialzationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:25
 * <P>项目初始化类</P>
 */
@Api(tags = "项目初始化")
@RestController
public class InitialzationController {

    @Autowired
    IInitialzationService iInitialzationService;

    /**
     * 数据库初始化
     *
     * @param DBInitialzation
     * @return {@Code String}
     */
    @ApiOperation(value = "数据库初始化，通过该方法设置数据库、用户名、密码")
    @PostMapping("/dbInit")
    public String dbInit(@RequestBody DBInitialzation DBInitialzation) {
        return iInitialzationService.dbInit(DBInitialzation);
    }

    /**
     * 数据库校验
     * @param DBInitialzation
     * @return
     */
    @ApiOperation(value = "数据库信息校验，检测数据库是否连接成功。", notes = "返回true or false")
    @GetMapping("/dbValidate")
    public boolean dbInitValidate(DBInitialzation DBInitialzation) {
        return iInitialzationService.dbValidate(DBInitialzation);
    }

    /**
     * 设置企业logo
     *
     * @return
     */
    @ApiOperation(value = "设置企业LOGO")
    @PostMapping("/setLogo")
    public String setLogo(@RequestBody MultipartFile file) {
        return iInitialzationService.setLogo(file);
    }

    /**
     * 设置背景图
     * @return
     */
    @ApiOperation(value = "设置背景图")
    @PostMapping("/setBackgroundImage")
    public String setBackgroundImage(@RequestBody MultipartFile file) {
        return iInitialzationService.setBackgroundImage(file);
    }

    /**
     * 重启系统
     * @param signInPage
     * @return
     */
    @ApiOperation(value = "设置完成，重启系统")
    @PostMapping("/reStart")
    public boolean reStart(@RequestBody SignInPage signInPage) {
        //System.exit(200);
        //jar包名
        //System.out.println("filePath:" + System.getProperty("java.class.path") + ",当前方法:InitialzationController.systemExit()");
        //jar包路径
        //System.out.println("filePath:" + System.getProperty("user.dir") + ",当前方法:InitialzationController.systemExit()");
        /*try {
            //String filePath1 = String.valueOf(FileResourceLoader.class.getResource("/static/restart.bat"));
            String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\restart.bat";
            //String filePath1 = "http://localhost:8084/restart.bat";
            Runtime.getRuntime().exec(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return iInitialzationService.setCopyrightInfo(signInPage);
    }
}
