package com.example.myproject;

/**
 * Created by wujiawu on 2017/5/5.
 */
public interface MyService {

    MyTest findByName(String name);

    MyTest addOne(MyTest myTest);
}
