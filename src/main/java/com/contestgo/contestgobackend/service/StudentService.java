package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.bean.Student;

public interface StudentService {

    Student queryUserByName(String username);

    String queryUserEmailByName(String username);

    void createUser(String username, String password);
}
