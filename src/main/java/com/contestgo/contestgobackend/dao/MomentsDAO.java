package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MomentsDAO {
    @Select("SELECT moments_id, moments_title, moments_publisher FROM moments")
    @Results({@Result(column = "moments_id", property = "momentsId", id =true),
              @Result(column = "moments_title", property = "momentsTitle"),
              @Result(column = "moments_publisher", property = "momentsPublisher")})
    List<MomentsVO> getMoments();

    @Select("SELECT moments_id, moments_title, moments_publisher, moments_content, publish_time FROM moments " +
            "WHERE moments_id = #{moments_id}")
    @Results({@Result(column = "moments_id", property = "momentsId", id =true),
              @Result(column = "moments_title", property = "momentsTitle"),
              @Result(column = "moments_publisher", property = "momentsPublisher"),
              @Result(column = "moments_content", property = "momentsContent"),
              @Result(column = "publish_time", property = "publishTime")})
    MomentsContentVO getMomentsContent(@Param("moments_id")int momentsId);

    @Insert("INSERT INTO moments(moments_title, moments_publisher, moments_content) " +
            "VALUES(#{moments_title}, #{moments_publisher}, #{moments_content})")
    void insertMoments(@Param("moments_title")String momentsTitle, @Param("moments_publisher")String momentsPublisher,
                       @Param("moments_content")String momentsContent);
}
