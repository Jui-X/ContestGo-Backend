package com.contestgo.contestgobackend.Service;

import com.contestgo.contestgobackend.DO.Student;

public interface StudentService {

    public Student queryUserByName(String username);

    public void createUser(String username, String password);
}
