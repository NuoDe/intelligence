package com.nuode.intelligence.modular.demo.controller;


import com.nuode.intelligence.modular.demo.entity.User;
import com.nuode.intelligence.modular.demo.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author luzhenqian
 * @since 2018-10-11
 */
@RestController
@RequestMapping("/demo/user")
@Api(tags = "用户信息Demo")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping
    public List<User> getUserInfoAll() {
        return iUserService.getUserInfoAll();
    }

    @GetMapping("/{id}")
    public User getUserInfoAll(@PathVariable int id) {
        return iUserService.getUserInfo(id);
    }

    @PostMapping
    public boolean getUserInfoAll(@RequestBody User user) {
        return iUserService.addUser(user)==0?false:true;
    }
}
