package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.pojo.UserExample;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(Integer id) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andIdEqualTo(id);

        List<User> userList =  userMapper.selectByExample(userExample);

        if(userList!=null)
        {
            return userList.get(0);
        }

        return null;
    }
}
