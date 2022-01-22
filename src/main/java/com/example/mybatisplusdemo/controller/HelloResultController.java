package com.example.mybatisplusdemo.controller;

import com.example.mybatisplusdemo.common.ResponseResultBody;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.common.exception.ResultException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/helloResult")
@ResponseResultBody
public class HelloResultController {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<String, Object>();
        INFO.put("name", "galaxy");
        INFO.put("age", "70");
    }

    @GetMapping("hello")
    public HashMap<String, Object> hello() {
        return INFO;
    }

    /** 测试重复包裹 */
    @GetMapping("result")
    public Result<Map<String, Object>> helloResult() {
        return Result.success(INFO);
    }

    @GetMapping("helloError")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }

    /**
     * 因为正常响应的返回体
     * 以及通过全局处理+注解 捕获了
     * 所以失败的操作，需要通过异常抛出，再全局捕获抛出error操作码
     * @return
     * @throws Exception
     */
    @GetMapping("helloMyError")
    public HashMap<String, Object> helloMyError() throws Exception {
        throw new ResultException();
    }
}
