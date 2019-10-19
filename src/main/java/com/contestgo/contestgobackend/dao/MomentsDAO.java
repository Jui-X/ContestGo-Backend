package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.MomentsVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentsDAO {
    @Select("SELECT moments_id, moments_title, moments_publisher FROM moments")
    List<MomentsVO> getMoments();
}
