package com.example.mybatisplusdemo.service;

import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired(required=false)
    public UserMapper userMapper;

    public List<User> findAllUser(){
        return userMapper.findAllUser();
    }

    public User findUserByUserId(int userid){
        return userMapper.selectById(userid);
    }

    public int insertUser(User user){
        return userMapper.insert(user);
    }
    public int deleById(int id){
        return userMapper.deleteById(id);
    }
}

