package com.example.mybatisplusdemo.batchMapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.entity.User;

/**
 * dao接口，继承mybatis-plus接口IService<T>
 * T为数据表对应po
 */
public interface UserIService extends IService<User> {
}
