package com.yhx.mvc.service.impl;

import com.yhx.mvc.mapper.UserMapper;
import com.yhx.mvc.model.User;
import com.yhx.mvc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional  //开启事务，默认所有方法均参与事务
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource  //@Autowired 也可用它替代
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.NOT_SUPPORTED) //本方法不参与事务,通常对单表增删改不需要加事务，只有多表增删改才用事务
    @Override
    public int deleteByPrimaryKey(Integer uid) {
        System.out.println("Service delete");
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(User record) {
       System.out.println("Service add");
       userMapper.insert(record);
       if(1==1) throw new RuntimeException("触发异常");//故意触发异常，在Spring事务管理中，当遇到运行期异常，就会自动回滚事务
       return userMapper.insert(record);
    }

    @Transactional(readOnly = true)//读取操作通常设为只读事务
    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
