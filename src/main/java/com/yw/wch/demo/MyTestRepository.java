package com.yw.wch.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wujiawu on 2017/5/5.
 */
public interface MyTestRepository extends JpaRepository<MyTest, String> {
    MyTest findByName(String name);
}
