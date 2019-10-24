package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.domain.Student;
import com.contestgo.contestgobackend.dao.StudentDAO;
import com.contestgo.contestgobackend.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student queryUserByName(String username) {return studentDAO.selectUserByName(username);}

    @Override
    public String queryUserEmailByName(String username) {
        return studentDAO.selectUserEmailByName(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(String username, String password) {
        studentDAO.insertUser(username, password);}

}
