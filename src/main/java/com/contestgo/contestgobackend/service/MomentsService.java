package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;

import java.util.List;

public interface MomentsService {
    List<MomentsVO> getMoments();

    MomentsContentVO getMomentsContent(int momentsId);

    void postMoments(String momentsTitle, String momentsPublisher, String momentsContent);
}
