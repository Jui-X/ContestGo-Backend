package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.domain.Student;

public interface StudentService {

    Student queryUserByName(String username);

    void createUser(String username, String password);
}
