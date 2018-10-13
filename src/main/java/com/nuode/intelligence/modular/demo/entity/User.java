package com.nuode.intelligence.modular.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author luzhenqian
 * @since 2018-10-11
 */
@Data
@ApiModel("用户信息")
public class User{

    @ApiModelProperty("唯一标识")
    private long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @TableField("userName")
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 状态
     */
    private String state;

    /**
     * 爱好
     */
    private String interest;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 上次登录时间
     */
    private String time;


}
