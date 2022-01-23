package com.example.mybatisplusdemo.common.exception;

import com.example.mybatisplusdemo.common.ResultStatus;
import lombok.Data;

@Data
public class ResultException extends Exception{
    private ResultStatus resultStatus= ResultStatus.BAD_REQUEST;

}
