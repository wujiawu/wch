package com.example.myproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by wujiawu on 2017/5/5.
 */
public interface MyTestRepository extends JpaRepository<MyTest, String> {
    MyTest findByName(String name);
}
