package com.example.mybatisplusdemo.common.util;

import lombok.Data;
import org.springframework.http.HttpStatus;


public enum ErrorCode {

    NULL_OBJ(HttpStatus.INTERNAL_SERVER_ERROR,500,"对象为空"),
    ERROR_ADD_USER(HttpStatus.INTERNAL_SERVER_ERROR,500,"添加用户失败"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,500,"系统繁忙，请稍后再试...."),
    FILE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR,500,"你要读取的资源找不到");

    /** 返回的HTTP状态码,  符合http请求 */
    private HttpStatus httpStatus;
    /** 业务异常码 */
    private Integer code;
    /** 业务异常信息描述 */
    private String message;

    ErrorCode(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
