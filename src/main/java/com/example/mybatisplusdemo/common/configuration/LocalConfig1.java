package com.example.mybatisplusdemo.common.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 希望读取application.properties的方法三 - 配置二
 * 通过 ConfigurationProperties 获取，然后通过 context读取配置类相应的数值
 *
 *  需要在 @Configuration注解修饰的类中汇总，然后读取
 * 参考文章：https://www.cnblogs.com/lql6/p/11792483.html
 */
@Data
@ToString
public class LocalConfig1 {
    private String name;
    private String pwd;
}
