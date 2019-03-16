package com.contestgo.contestgobackend.Service;

import com.contestgo.contestgobackend.Pojo.User;

public interface UserService {

    public User queryUserByName(String username);

    public void createUser(String username, String password);
}
