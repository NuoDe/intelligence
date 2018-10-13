package com.nuode.intelligence.modular.demo.mapper;

import com.nuode.intelligence.modular.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luzhenqian
 * @since 2018-10-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
