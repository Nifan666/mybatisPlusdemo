package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.batchMapper.UserIService;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired(required=false)
    public UserMapper userMapper;

    @Autowired
    private UserIService userIService;

    public void batchUpdateErm(){
        List<User> ermUsers = new ArrayList<>();
        // for批量插入数据 begin
//        ermUser.setUserid();
        for(int i = 0; i<= 10; i++){
            User ermUser = new User();
            ermUser.setUsername("name" + i);
            ermUser.setPassword("psw" + i);
            ermUsers.add(ermUser);
        }
        // end
        // 批量修改
//        userInfoService.updateBatchById(ermUsers);
        // 批量插入
//        userBatchIService.saveBatch(ermUsers);
//        myUserIService.saveBatch(ermUsers);
//        userInfoService.saveBatch(ermUsers);
        userIService.saveBatch(ermUsers);
    }

    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    public User findUserByUserId(int userid){
//        userMapper.saveOrUpdateBatch();
        return userMapper.selectById(userid);
    }
}

