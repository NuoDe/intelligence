package com.nuode.intelligence.modular.system.controller;

import com.nuode.intelligence.modular.system.entity.SignInPage;
import com.nuode.intelligence.modular.system.service.ISignInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-13-14:31
 */
@Api(tags = "登录页面")
@RestController
@RequestMapping("/sginIn")
public class SignInController {

    @Autowired
    ISignInService iSignInService;

    /**
     * 初始化登录页面
     * @return
     */
    @ApiOperation(value = "初始化登录页面",notes = "返回企业logo、背景图、版权信息等")
    @GetMapping("/initSignInPage")
    public SignInPage initSignInPage(){
        return iSignInService.initSignInPage();
    }
}
