package com.example.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by wujiawu on 2017/5/5.
 */
@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyTestRepository myTestRepository;


    @Override
    public MyTest findByName(String name) {
        return myTestRepository.findByName(name);
    }

    @Override
    @Transactional
    public MyTest addOne(MyTest myTest) {
        return myTestRepository.save(myTest);
    }
}
