package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {

    default  List<User> findAllUser(){
        return selectList(null);
    }
//    default  List<User> findAllUser(Integer id,int offset,int size){
//        Page<User> page = new Page<>(offset,size);
//        QueryWrapper<User> query = new QueryWrapper<>();
//        query.eq(id!=null,"id",id);
//
//        return selectPage(page,query);
//
//    }


//    /**
//     * 自定义批量插入
//     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
//     */
//    int insertBatch(@Param("list") List<User> list);
//
//    /**
//     * 自定义批量新增或更新
//     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
//     */
//    int mysqlInsertOrUpdateBath(@Param("list") List<User> list);
}

