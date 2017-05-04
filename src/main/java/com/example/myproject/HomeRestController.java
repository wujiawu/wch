package com.example.myproject;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeRestController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Map<String,String> home() {
        Map<String,String> data = new HashMap<>();
        data.put("hello","world");
        return data;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Map<String,String> post(@RequestParam  String foo,@RequestParam String bar) {
        Map<String,String> data = new HashMap<>();
        data.put("foo","foo"+foo);
        data.put("bar","bar"+bar);
        return data;
    }

}