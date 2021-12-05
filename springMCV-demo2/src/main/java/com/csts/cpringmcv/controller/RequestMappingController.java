package com.csts.cpringmcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {
    @RequestMapping(value = {"/target", "/requestMapping"},
            method = {RequestMethod.GET, RequestMethod.POST})
    public String target(){
        return "target";
    }

    @RequestMapping(value = "/testParamsAndHeaders",
                    params = {"username!=admin"})
    public String testParams(){
        return "target";
    }

//    @RequestMapping("/a?a/testAnt")
//    @RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "target";
    }

    @GetMapping(value = "testPathVariable/{id}/{name}")
    public String testPathVariable(@PathVariable("id") Integer id,
                                   @PathVariable("name") String name){
        System.out.println("id= "+ id+ "\t name= "+ name);
        return "target";
    }
}
