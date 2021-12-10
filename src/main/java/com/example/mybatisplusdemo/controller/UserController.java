package com.example.mybatisplusdemo.controller;


import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 配置文件读取
     */
    @Value("${define.test.key}")
    private String testKey;

    @RequestMapping("/insert")
    public String insertUser(@RequestBody User user){
        return String.valueOf(userService.insertUser(user));
    }

    @RequestMapping("/dele")
    public String dele(@RequestParam Integer id){
        return String.valueOf( userService.deleById(id));
    }

    @RequestMapping("/testKey")
    public String getTestKey(){


        // 2. 根据 id 删除
        // userMapper.deleteById(6);

        // 3. 根据 columnMap 条件，删除记录
        // Maps 属于 com.google.common.collect.Maps 包，来自于 Guava
        // Guava 中文是石榴的意思，该项目是 Google 的一个开源项目，包含许多 Google 核心的 Java 常用库
        /*Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("id", 3);

        userMapper.deleteByMap(columnMap);*/

        // 4. 查询所有数据
        // 不指定条件，直接传递 null
        /*List<User> userList = userMapper.selectList(null);
        userList.forEach(user -> System.out.println("用户：" + user));*/
        return testKey;
    }

    @RequestMapping("/getAllUser")
    public List<User> findAll(){
        return userService.findAllUser();
    }

    @RequestMapping("/getUserByUserID/{userid}")
    public User findUserByUserId(@PathVariable int userid){
        return userService.findUserByUserId(userid);
    }
}


