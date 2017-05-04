package com.example.myproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wujiawu on 2017/5/5.
 */
@Entity
@Table(name = "mytest")
public class MyTest implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
