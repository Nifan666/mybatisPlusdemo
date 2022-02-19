package com.example.mybatisplusdemo.common.exception;

/**
 * 统一全局异常处理
 *
 * 负责异常的响应体返回
 *
 * -> 废弃,后期可以整个类删除，无影响
 */
public class MyExceptionHandler{

}


//@Configuration
//public class MyExceptionHandler implements HandlerExceptionResolver {
//
//    private PrintWriter getPrintWrite(HttpServletResponse response) {
//        PrintWriter out = null;
//        try {
//            response.setHeader("Content-type", "text/html;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            out = response.getWriter();
//        } catch (IOException e) {
////            log.error("PrintWriter is exception", e);
//        }
//        return out;
//    }
//
//    /**
//     * 过时代码
//     *
//     * 卧槽, 异常处理, 差点把这茬给忘了, 这个异常处理就有很多方法了,
//     * 先看看我师傅的处理方式, 我刚拿到这个代码的时候很想吐槽,
//     * 对异常类的处理这么残暴的吗, 直接用PrintWriter直接输出结果,
//     * 果然是老师傅, 我要是有100个异常类,
//     * 不得要写100个 if else了. 赶紧改改睡吧
//     * 缺点：
//     *   这里需要对每个不同的Exception类，在一个方法内进行相应的操作。十分耦合
//     *   不过也可以学习ResponseResultBodyAdvice，写不同的方法，对应不同的Exception类，进行操作。
//     */
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        PrintWriter out = getPrintWrite(response);
//        String res = null;
//        if (ex instanceof ResultException) {
////            res = JSON.toJSONString(ResultStatus.INTERNAL_SERVER_ERROR.getCode(), SerializerFeature.valueOf(ex.getMessage()));
//            out.write(ex.getMessage() + 500);
//        } else {
//            out.write("服务器异常" + 500);
////            res = JSON.toJSONString(ResultStatus.BAD_REQUEST.getCode(), SerializerFeature.valueOf("服务器异常"));
//        }
////        out.write(res);
//        if (null != out) {
//            out.close();
//        }
//        ModelAndView mav = new ModelAndView();
////        mav.addObject(res);
//        return mav;
////    }
////}
