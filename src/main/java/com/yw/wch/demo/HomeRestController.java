package com.yw.wch.demo;

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
public class HomeRestController {

    @Autowired
    private Config config;

    @Autowired
    private MyService myService;

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
    public MyTest myTest( @RequestParam  String name) {
        return myService.findByName(name);
    }


    @RequestMapping(value = "/my-test",method = RequestMethod.POST)
    public MyTest myTest(@RequestParam  String id, @RequestParam String name) {
        MyTest myTest = new MyTest();
        myTest.setId(id);
        myTest.setName(name);
        return myService.addOne(myTest);
    }

}