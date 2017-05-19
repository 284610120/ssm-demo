package com.yhx.mvc.controller;

import com.yhx.mvc.model.User;
import com.yhx.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/mvc")
    public String helloMvc() {
        return "home";
    }

    @ResponseBody
    @RequestMapping("/json")
    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("3333");
        return list;
    }

    @RequestMapping(value = "/login") // method = RequestMethod.POST
    public String login(HttpServletRequest request, HttpServletResponse response) {
        if ("GET".equalsIgnoreCase(request.getMethod()))  return "login";
        String name = request.getParameter("name");
        request.getSession().setAttribute("user",name);
        return "redirect:/hello/main";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "home";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return "redirect:/hello/login";
    }

    @RequestMapping(value = "/test")
    public String test2() {
        //测试Logback日志输出
        log.info("In viewCourse, courseId = {}", "Info");
        log.error("In viewCourse, courseId = {}", "Test");
        User user = new User("李四","123");
        //测试事务方法
        userService.insert(user);
        return "login";
    }
}