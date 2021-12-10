package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusdemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void testSelect2(){
        IPage<User> page = selectUserPage();

        List<User> userList = page.getRecords();
        userList.forEach(user -> System.out.println("用户：" + user));
        
        
    }

    // 查询年龄在 20-30 名字为 cuihua 的用户
    public  IPage<User>  selectUserPage() {

        Page page = new Page<User>(0, 1);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().between("userid", 0, 20);
        return userMapper.selectPage(page, queryWrapper);
    }


}
