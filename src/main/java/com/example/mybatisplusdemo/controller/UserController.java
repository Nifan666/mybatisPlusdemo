package com.example.mybatisplusdemo.controller;


import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 打印日志的方法
 * 方法一：
 * @Slf4j + log.info
 *
 * 方法二：
 * final static Logger logger = LoggerFactory.getLogger(HelloController.class);
 * logger.info
 *
 * 本类中使用的是：方法一
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public List<User> findAll(){
        log.info("成功查询到左右用户资料");
        return userService.findAllUser();
    }

    @RequestMapping("/getUserByUserID/{userid}")
    public User findUserByUserId(@PathVariable int userid){
        return userService.findUserByUserId(userid);
    }

    @RequestMapping("/batchUpdateErm")
    public String batchUpdateErm(){
        userService.batchUpdateErm();
        return "batchUpdateSuccess";
    }
}


