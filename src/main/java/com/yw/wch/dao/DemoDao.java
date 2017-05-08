package com.yw.wch.dao;

import com.yw.wch.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by wujiawu on 2017/5/5.
 */
public interface DemoDao extends JpaRepository<Demo, String>,JpaSpecificationExecutor<Demo> {
    Demo findByName(String name);
}
