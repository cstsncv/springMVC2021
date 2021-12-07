package com.csts.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息, id: "+ id);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("添加用户, 用户名: "+ username+ ", 密码: "+ password);
        return "success";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("修改用户, 用户名: "+ username+ ", 密码: "+ password);
        return "success";
    }
}
