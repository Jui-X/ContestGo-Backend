package com.contestgo.contestgobackend.DAO;

import com.contestgo.contestgobackend.DO.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentDAO {

    @Select("SELECT * FROM student WHERE name = #{username}")
    public Student selectUserByName(@Param("username")String username);

    @Insert("INSERT INTO student(name, password) VALUES(#{username}, #{password})")
    public void insertUser(@Param("username")String stu_name, @Param("password") String password);
}
