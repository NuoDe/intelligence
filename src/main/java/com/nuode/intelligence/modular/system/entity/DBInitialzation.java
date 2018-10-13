package com.nuode.intelligence.modular.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-08-20:21
 */
@ApiModel("数据库信息配置实体")
@Data
public class DBInitialzation {
    @ApiModelProperty("数据库驱动类")
    private String driverClassName;
    @ApiModelProperty("数据库地址")
    private String url;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
