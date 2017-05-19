package com.yhx.mvc.mapper;

import com.yhx.mvc.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-05-16.
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer uid);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
}