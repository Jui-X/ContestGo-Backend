package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentsDAO {
    @Select("SELECT moments_id, moments_title, moments_publisher FROM moments")
    List<MomentsVO> getMoments();

    @Select("SELECT moments_id, moments_title, moments_publisher, moments_content, publish_time FROM moments " +
            "WHERE moments_id = #{moments_id}")
    MomentsContentVO getMomentsContent(@Param("moments_id")int moments_id);

    @Insert("INSERT INTO moments(moments_title, moments_publisher, moments_content) " +
            "VALUES(#{moments_title}, #{moments_publisher}, #{moments_content})")
    void insertMoments(@Param("moments_title")String moments_title, @Param("moments_publisher")String moments_publisher,
                       @Param("moments_content")String moments_content);
}
