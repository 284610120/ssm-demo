package com.yhx.mvc.service;

import com.yhx.mvc.model.User;

/**
 * Created by Administrator on 2017-05-16.
 */
public interface UserService {
    int deleteByPrimaryKey(Integer uid);
    int insert(User record);
    User selectByPrimaryKey(Integer uid);
}
