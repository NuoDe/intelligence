package com.nuode.intelligence.modular.demo.service.impl;

import com.nuode.intelligence.modular.demo.entity.User;
import com.nuode.intelligence.modular.demo.mapper.UserMapper;
import com.nuode.intelligence.modular.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luzhenqian
 * @since 2018-10-11
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserInfoAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User getUserInfo(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
