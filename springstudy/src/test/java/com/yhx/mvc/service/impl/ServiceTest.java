package com.yhx.mvc.service.impl;


import com.yhx.mvc.model.User;
import com.yhx.mvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017-05-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml","classpath:spring/applicationContext.xml"})
public class ServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testService() {
        userService.insert(new User("王五","123"));
    }

    @Test
    public void testDelete() {
        System.out.println(userService.deleteByPrimaryKey(38));
    }
}
