package com.example.demo;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class response {

    @RequestMapping("/ajax")
    @ResponseBody
    public  String get(String name){
        return "hello";
    };

}
