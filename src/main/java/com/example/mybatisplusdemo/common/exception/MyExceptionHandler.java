package com.example.mybatisplusdemo.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.mybatisplusdemo.common.ResultStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一全局异常处理
 */
@Configuration
public class MyExceptionHandler implements HandlerExceptionResolver {

    private PrintWriter getPrintWrite(HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
        } catch (IOException e) {
//            log.error("PrintWriter is exception", e);
        }
        return out;
    }

    /**
     * 过时代码
     *
     * 卧槽, 异常处理, 差点把这茬给忘了, 这个异常处理就有很多方法了,
     * 先看看我师傅的处理方式, 我刚拿到这个代码的时候很想吐槽,
     * 对异常类的处理这么残暴的吗, 直接用PrintWriter直接输出结果,
     * 果然是老师傅, 我要是有100个异常类,
     * 不得要写100个 if else了. 赶紧改改睡吧
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        PrintWriter out = getPrintWrite(response);
        String res = null;
        if (ex instanceof ResultException) {
            res = JSON.toJSONString(ResultStatus.INTERNAL_SERVER_ERROR.getCode(), SerializerFeature.valueOf(ex.getMessage()));

        } else {
            res = JSON.toJSONString(ResultStatus.BAD_REQUEST.getCode(), SerializerFeature.valueOf("服务器异常"));
        }
        out.write(res);
        if (null != out) {
            out.close();
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject(res);
        return mav;
    }
}
