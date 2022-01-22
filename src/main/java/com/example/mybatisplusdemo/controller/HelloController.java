package com.example.mybatisplusdemo.controller;

import com.example.mybatisplusdemo.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 到这里我们已经简单的实现了统一JSON格式了,
 * 但是我们也发现了一个问题了,想要返回统一的JSON格式需要返回Result<Object>才可以,
 * 我明明返回Object可以了, 为什么要重复劳动, 有没有解决方法,
 * 当然是有的啦, 下面我们开始优化我们的代码吧
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        return INFO;
    }

    @GetMapping("/result")
    @ResponseBody
    public Result<Map<String, Object>> helloResult() {
        return Result.success(INFO);
    }
}
