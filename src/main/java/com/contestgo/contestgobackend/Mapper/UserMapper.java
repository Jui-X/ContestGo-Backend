package com.contestgo.contestgobackend.Mapper;

import com.contestgo.contestgobackend.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{username}")
    public User queryUserByName(@Param("username")String username);

    @Insert("INSERT INTO user(name, password) VALUES(#{username}, #{password})")
    public void createUser(@Param("username")String username, @Param("password") String password);
}
