package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;

import java.util.List;

public interface MomentsService {
    List<MomentsVO> getMoments();

    MomentsContentVO getMomentsContent(int moments_id);

    void postMoments(String moments_title, String moments_publisher, String moments_content);
}
