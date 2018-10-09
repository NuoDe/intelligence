package com.nuode.intelligence.modular.system.controller;

import com.nuode.intelligence.modular.system.entity.DBInitialzation;
import com.nuode.intelligence.modular.system.service.IInitialzationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:25
 * <P>项目初始化类</P>
 */
@RestController
@Api(tags = "项目初始化")
public class InitialzationController {

    @Autowired
    IInitialzationService iInitialzationService;

    /**
     *数据库初始化
     * @param DBInitialzation
     * @return {@Code String}
     */
    @PostMapping("/dbInit")
    @ApiOperation(value = "数据库初始化，通过该方法设置数据库、用户名、密码")
    public String dbInit(@RequestBody DBInitialzation DBInitialzation){
        return iInitialzationService.dbInit(DBInitialzation);
    }

    /**
     * 数据库校验
     * @param DBInitialzation
     * @return
     */
    @GetMapping("/dbValidate")
    @ApiOperation(value = "数据库信息校验，检测是否连接成功。",notes = "返回true or false")
    public boolean dbInitValidate(DBInitialzation DBInitialzation){
        return iInitialzationService.dbValidate(DBInitialzation);
    }
}
