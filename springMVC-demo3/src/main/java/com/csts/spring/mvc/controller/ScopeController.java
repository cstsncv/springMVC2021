package com.csts.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testRequestServletAPI")
    // 1. 使用ServletAPI向Request域对象共享数据
    public String testRequestServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "Hello, ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    // 2. 使用ModelAndView向Request域对象共享数据
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();

        // 处理模型数据, 即向请求域request共享数据
        mav.addObject("testRequestScope", "hello, ModelAndView");

        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    // 3. 使用Model向Request域对象共享数据
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello, Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    // 4. 使用Map向Request域对象共享数据
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello, testMap");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    // 5. 使用ModelMap向Request域对象共享数据
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello, modelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }


    @RequestMapping("/testSession")
    // 6. 使用ServletAPI HttpSession向Session域对象共享数据
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello, Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    // 7. 使用ServletAPI HttpSession向Application域对象共享数据
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "hello, Application");
        return "success";
    }
}
