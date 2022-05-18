package com.example.mybatisplusdemo.excelBox;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatisPlusdemo
 * @description: excel处理类
 * @author: hzl
 * @create: 2022-05-18 23:56
 **/

public class ExcelListener<T> extends AnalysisEventListener<T> {

    private static final int BATCH_COUNT = 5;
    List<T> list = new ArrayList<T>();

    // 此处可传Spring IOC对象进行保存数据库
    public ExcelListener(){
    };


    // 读取每一条
    @Override
    public void invoke(T data, AnalysisContext context) {
        System.out.println(JSON.toJSONString(data));
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
        list.add(data);
    }

    // 读取完毕后
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("读取完成！");
        saveData();
        list.clear();
    }

    // 保存操作
    private void saveData(){
        System.out.println("存入数据库");
    }
}
