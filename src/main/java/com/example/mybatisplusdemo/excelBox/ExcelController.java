package com.example.mybatisplusdemo.excelBox;

import com.alibaba.excel.EasyExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

/**
 * @program: mybatisPlusdemo
 * @description:
 * @author: hzl
 * @create: 2022-05-18 23:57
 **/

@Controller
public class ExcelController {
    @PostMapping("/addExcel")
    public String addExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelEntity.class, new ExcelListener<ExcelEntity>()).sheet().doRead();
        return "ok";


    }
}
