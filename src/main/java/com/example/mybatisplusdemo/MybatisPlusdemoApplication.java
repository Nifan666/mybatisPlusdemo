
package com.example.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置

@MapperScan("com.example.mybatisplusdemo.mapper")
public class MybatisPlusdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusdemoApplication.class, args);
    }

}
