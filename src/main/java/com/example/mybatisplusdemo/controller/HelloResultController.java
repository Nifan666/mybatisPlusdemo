package com.example.mybatisplusdemo.controller;

import com.example.mybatisplusdemo.common.ResponseResultBody;
import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.common.exception.ResultException;
import org.apache.ibatis.mapping.Environment;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${local.ip.addr}")
    private String ip;

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

    /**
     * 用于测试 MyExceptionHandle 系统异常处理
     *
     * 或者 ResponseResultBodyAdvice 的ExceptionHandler 全局异常处理
     * @return
     * @throws Exception
     */
    @GetMapping("helloError")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }

    /**
     * 用于测试 MyExceptionHandle 自定义异常区分处理
     * 或者 ResponseResultBodyAdvice 的ExceptionHandler 全局异常处理
     *
     * @return
     * @throws Exception
     */
    @GetMapping("resultExceptionTest")
    public HashMap<String, Object> resultExceptionTest() throws Exception {
        throw new ResultException();
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

    /**
     * 希望读取application.properties的方法二
     * 通过@Value注解 获取
     *
     * 参考文章：https://www.cnblogs.com/lql6/p/11792483.html
     * @return
     */
    @GetMapping("getConfigValueMethod2")
    public HashMap<String, Object> getConfigValueMethod2() {
        HashMap map = new HashMap();
        map.put("ip",ip);
        return map;
    }



}
