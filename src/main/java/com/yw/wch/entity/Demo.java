package com.yw.wch.entity;

import lombok.Data;

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
@Data
public class Demo implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column
    private String descr;

}
