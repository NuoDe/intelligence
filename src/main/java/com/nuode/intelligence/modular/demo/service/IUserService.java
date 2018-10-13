package com.nuode.intelligence.modular.demo.service;

import com.nuode.intelligence.modular.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luzhenqian
 * @since 2018-10-11
 */
public interface IUserService {

    List<User> getUserInfoAll();
    User getUserInfo(int id);
    int addUser(User user);
}
