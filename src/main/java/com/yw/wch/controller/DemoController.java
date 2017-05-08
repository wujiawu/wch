package com.yw.wch.controller;

import com.yw.wch.config.DemoConfig;
import com.yw.wch.entity.Demo;
import com.yw.wch.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoConfig config;

    @Autowired
    private DemoService service;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Map<String,String> home() {
        Map<String,String> data = new HashMap<>();
        data.put("hello","world");
        return data;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Map<String,String> post(@RequestParam  String foo,@RequestParam String bar) {
        Map<String,String> data = new HashMap<>();
        data.put("foo","foo"+foo);
        data.put("bar","bar"+bar);
        return data;
    }


    @RequestMapping(value = "/yaml",method = RequestMethod.GET)
    public List<String> yaml() {
        return config.getServers();
    }


    @RequestMapping(value = "/my-test",method = RequestMethod.GET)
    public Demo myTest(@RequestParam  String name) {
        return service.findByName(name);
    }


    @RequestMapping(value = "/my-test",method = RequestMethod.POST)
    public Demo myTest(@RequestParam  String id, @RequestParam String name) {
        Demo myTest = new Demo();
        myTest.setId(id);
        myTest.setName(name);
        return service.addOne(myTest);
    }

}