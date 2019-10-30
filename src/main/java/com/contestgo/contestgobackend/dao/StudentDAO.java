package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentDAO {

    @Select("SELECT * FROM student WHERE name = #{username}")
    Student selectUserByName(@Param("username")String username);

    @Select("SELECT email_address FROM student WHERE name = #{username}")
    String selectUserEmailByName(@Param("username")String username);

    @Insert("INSERT INTO student(name, password) VALUES(#{username}, #{password})")
    void insertUser(@Param("username")String username, @Param("password") String password);
}
