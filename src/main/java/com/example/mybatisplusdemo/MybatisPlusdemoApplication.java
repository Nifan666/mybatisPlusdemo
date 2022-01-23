package com.example.mybatisplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置

@MapperScan("com.example.mybatisplusdemo.mapper")
public class MybatisPlusdemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MybatisPlusdemoApplication.class, args);
        ConfigurableApplicationContext context =  SpringApplication.run(MybatisPlusdemoApplication.class, args);
        getConfigValueMethod1(context);
    }

    /**
     * 希望读取application.properties的方法一
     * 通过Enviroment 获取
     *
     * 参考文章：https://www.cnblogs.com/lql6/p/11792483.html
     * @param context
     */
    public static void getConfigValueMethod1(ConfigurableApplicationContext context ){
        ConfigurableEnvironment environment = context.getEnvironment();
        String ip = environment.getProperty("local.ip.addr");
        System.out.println(ip);
    }
    
}
