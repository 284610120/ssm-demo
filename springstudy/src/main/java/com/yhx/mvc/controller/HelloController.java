package com.yhx.mvc.controller;

import com.yhx.mvc.model.User;
import com.yhx.mvc.service.UserService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        if ("GET".equalsIgnoreCase(request.getMethod())) return "login";
        String name = request.getParameter("name");
        request.getSession().setAttribute("user", name);
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
        User user = new User("李四", "123");
        //测试事务方法
        userService.insert(user);
        return "login";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            long size = file.getSize();
            String fileName = file.getOriginalFilename();
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String randomName = UUID.randomUUID().toString() + "." + ext;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath, randomName));
            log.debug("------------Process File:{},Size:{}--------------", filePath + randomName, size);
            return "success";
        }
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() throws IOException {
        return "upload";
    }
}