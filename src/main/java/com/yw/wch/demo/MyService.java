package com.yw.wch.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;


/**
 * Created by wujiawu on 2017/5/5.
 */
@Service
@Validated
public class MyService {

    @Autowired
    private MyTestRepository myTestRepository;


    public MyTest findByName(@Size(min = 2) String name) {
        return myTestRepository.findByName(name);
    }

    @Transactional
    public MyTest addOne(MyTest myTest) {
        return myTestRepository.save(myTest);
    }
}
