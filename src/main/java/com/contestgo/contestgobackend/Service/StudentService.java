package com.contestgo.contestgobackend.Service;

import com.contestgo.contestgobackend.Pojo.Student;

public interface StudentService {

    public Student queryUserByName(String username);

    public void createUser(String username, String password);
}
