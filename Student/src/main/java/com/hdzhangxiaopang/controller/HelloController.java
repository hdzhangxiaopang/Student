package com.hdzhangxiaopang.controller;

import com.hdzhangxiaopang.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zhangguilin on 2017/6/13.
 */


@Controller
@ResponseBody
@RequestMapping("/hd")
public class HelloController {

    @Autowired
    private StudentProperties student;

    @GetMapping("/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
       return "id: "+myId;
    }
}

