package com.csts.mvc.controller;

import com.csts.mvc.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class HttpController {

    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody){
        log.info("requestBody: "+ requestBody);
        return "success";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        // 当前requestEntity表示整个请求报文信息
        log.info("Request Header: "+ requestEntity.getHeaders());
        log.info("Request Body: "+ requestEntity.getBody());
        return "success";
    }

    @GetMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello, response");
    }

    @GetMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @GetMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1, "zs", "12s", 11, "男");
    }

    @PostMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        log.info("username:"+ username+ "\tpassword: "+ password);
        return "OK, ajax";
    }

}
