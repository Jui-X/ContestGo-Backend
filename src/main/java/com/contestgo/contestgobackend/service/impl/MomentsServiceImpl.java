package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.dao.MomentsDAO;
import com.contestgo.contestgobackend.service.MomentsService;
import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 18:23
 **/
@Service
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsDAO momentsDAO;

    @Override
    public List<MomentsVO> getMoments() {
        return momentsDAO.getMoments();
    }

    @Override
    public MomentsContentVO getMomentsContent(int momentsId) {
        return momentsDAO.getMomentsContent(momentsId);
    }

    @Override
    public void postMoments(String momentsTitle, String momentsPublisher, String momentsContent) {
        momentsDAO.insertMoments(momentsTitle, momentsPublisher, momentsContent);
    }
}
