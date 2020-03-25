package com.example.start.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class response {

    @RequestMapping("/ajax")
    @ResponseBody
    public  String get(String name){
        return "hello";
    };

}
