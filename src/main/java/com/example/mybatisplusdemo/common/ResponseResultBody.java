package com.example.mybatisplusdemo.common;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * 从@ResponseBody注解入手了就创建一个注解类继承@ResponseBody
 * @ResponseResultBody 可以标记在类和方法上这样我们就可以跟自由的进行使用了
 *
 *
 * 为了避免每次 controller层返回结果时，都需要书写统一的响应体类，
 * 所以利用注解 + 全局处理 实现对所有方法的包装
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {

}
