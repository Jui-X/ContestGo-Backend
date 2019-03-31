package com.contestgo.contestgobackend.Service.ServiceImpl;

import com.contestgo.contestgobackend.DO.Student;
import com.contestgo.contestgobackend.DAO.StudentDAO;
import com.contestgo.contestgobackend.Service.StudentService;
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
    private StudentDAO studentMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student queryUserByName(String username) {return studentMapper.selectUserByName(username);}

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(String username, String password) {
        studentMapper.insertUser(username, password);}

}
