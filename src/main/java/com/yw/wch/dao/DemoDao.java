package com.yw.wch.dao;

import com.yw.wch.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wujiawu on 2017/5/5.
 */
public interface DemoDao extends JpaRepository<Demo, String> {
    Demo findByName(String name);
}
