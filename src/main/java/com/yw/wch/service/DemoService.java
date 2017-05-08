package com.yw.wch.service;

import com.yw.wch.core.DynamicSpecifications;
import com.yw.wch.core.SearchFilter;
import com.yw.wch.dao.DemoDao;
import com.yw.wch.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by wujiawu on 2017/5/5.
 */
@Service
@Validated
public class DemoService {

    @Autowired
    private DemoDao dao;


    public Demo findByName(@Size(min = 2) String name) {
//        return dao.findByName(name);
        Map<String,Object> search = new HashMap<>();
        search.put("EQ_name",name);
        return dao.findOne(DynamicSpecifications.bySearchFilter(SearchFilter.parse(search).values(),Demo.class));
    }

    @Transactional
    public Demo addOne(Demo myTest) {
        return dao.save(myTest);
    }
}
