package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.entity.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
    default  List<User> findAllUser(){
        return selectList(null);
    }
}

