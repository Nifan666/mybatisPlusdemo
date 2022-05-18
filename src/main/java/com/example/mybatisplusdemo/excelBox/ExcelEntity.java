package com.example.mybatisplusdemo.excelBox;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @program: mybatisPlusdemo
 * @description: excel导出的实体类
 * @author: hzl
 * @create: 2022-05-18 23:54
 **/

@Data
public class ExcelEntity {
    private String name;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private Integer age;
}
