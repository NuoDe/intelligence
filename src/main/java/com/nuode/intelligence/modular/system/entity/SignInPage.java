package com.nuode.intelligence.modular.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-12-16:55
 */
@ApiModel("登录页面信息实体")
@Data
@TableName("SignIn_page")
public class SignInPage {
    private int id;
    @ApiModelProperty("企业logo链接地址")
    private String logoUrl;
    @ApiModelProperty("背景图链接地址")
    private String backgroundImageUrl;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("版权信息")
    private String copyrightInfo;
}
