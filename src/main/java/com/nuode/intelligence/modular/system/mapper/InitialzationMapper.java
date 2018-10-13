package com.nuode.intelligence.modular.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nuode.intelligence.modular.system.entity.SignInPage;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-12-16:55
 */
@Mapper
public interface InitialzationMapper extends BaseMapper<SignInPage> {

    @ApiOperation(value = "创建表")
    Object createLoginPageTable();

    int setLoginPageInfo(SignInPage signInPage);
}
