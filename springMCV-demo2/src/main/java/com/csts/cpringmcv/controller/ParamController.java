package com.csts.cpringmcv.controller;

import com.csts.cpringmcv.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletApi")
    // 形参位置的request表示当前请求
    public String testServletApi(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username= "+ username + "\t,password= "+ password);
        System.out.println(session.toString());
        return "target";
    }

    @RequestMapping("/testParam")
    // 若请求参数中出现多个相同名称的请求参数, 可以在控制器方法的形参位置设置字符串类型或是字符串数组类型接收此请求参数
    // 若字符串形参, 最终结果为 请求参数的每个值之间使用,逗号拼接
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "defaultUserName") String username,
                            @RequestParam(value = "password") String password,
                            String[] hobby,
                            @RequestHeader(value = "SayHaha",required = true, defaultValue = "haha") String host,
                            @CookieValue("JSESSIONID") String JSESSIONID){
        System.out.println("username= "+ username + "\t,password= "+ password+
                "\t, hobby: "+ Arrays.toString(hobby)+ "\t, host= "+ host);
        System.out.println("JSESSIONID; "+ JSESSIONID);
        return "target";
    }

    @RequestMapping("/testBean")
    // 通过实体类获取请求参数
    public String testBean(User user){
        System.out.println(user);
        return "target";
    }
}
