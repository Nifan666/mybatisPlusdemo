package com.example.mybatisplusdemo.reflectTest;

/**
 1. @ClassName: Person
 2. @Description: 定义对象的行为
 3. @date: 2020-8-25 下午9:44:22
 4. */
public interface Person {

    /**
     * @Method: sing
     * @Description: 唱歌
     *
     * @param name
     * @return
     */
    String sing(String name);
    /**
     * @Method: sing
     * @Description: 跳舞
     *
     * @param name
     * @return
     */
    String dance(String name);
}

