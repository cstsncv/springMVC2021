package com.csts.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/testRest")
    public String testRest(){
        return "test_rest";
    }
}
