package com.example.mybatisplusdemo.reflectTest;


/**
 1. @ClassName: LiuDeHua
 2. @Description: 刘德华实现Person接口，那么刘德华会唱歌和跳舞了
 3. @date: 2020-8-25 下午9:22:24
 4. */
public class LiuDeHua implements Person {

    public String sing(String name){
        System.out.println("刘德华唱"+name+"歌！！");
        return "歌唱完了，谢谢大家！";
    }

    public String dance(String name){
        System.out.println("刘德华跳"+name+"舞！！");
        return "舞跳完了，多谢各位观众！";
    }
}
