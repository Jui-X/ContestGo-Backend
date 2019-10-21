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
    public MomentsContentVO getMomentsContent(int moments_id) {
        return momentsDAO.getMomentsContent(moments_id);
    }

    @Override
    public void postMoments(String moments_title, String moments_publisher, String moments_content) {
        momentsDAO.insertMoments(moments_title, moments_publisher, moments_content);
    }
}
