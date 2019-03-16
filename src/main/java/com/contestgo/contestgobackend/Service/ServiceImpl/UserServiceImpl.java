package com.contestgo.contestgobackend.Service.ServiceImpl;

import com.contestgo.contestgobackend.Pojo.User;
import com.contestgo.contestgobackend.Mapper.UserMapper;
import com.contestgo.contestgobackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-06 19:44
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByName(String username) {return userMapper.queryUserByName(username);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(String username, String password) {userMapper.createUser(username, password);}

}
