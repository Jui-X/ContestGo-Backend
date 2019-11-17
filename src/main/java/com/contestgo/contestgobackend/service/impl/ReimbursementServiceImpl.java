package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.dao.ContestDAO;
import com.contestgo.contestgobackend.dao.ReimbursementDAO;
import com.contestgo.contestgobackend.dao.TeamDAO;
import com.contestgo.contestgobackend.service.ReimbursementService;
import com.contestgo.contestgobackend.vo.ReimbursementContestVO;
import com.contestgo.contestgobackend.vo.ReimbursementRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-05 17:45
 **/
@Service
public class ReimbursementServiceImpl implements ReimbursementService {

    @Autowired
    private ReimbursementDAO reimbursementDAO;

    @Autowired
    private ContestDAO contestDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<ReimbursementContestVO> listMyReimbursementContest(String stuId) {
        List<Integer> myTeam = teamDAO.getMyTeam(stuId);

        List<ReimbursementContestVO> reimbursementContestVOList = new ArrayList<>();
        for (Integer teamNumber : myTeam) {
            ReimbursementContestVO reimbursementContestVO = contestDAO.getMyContestIdAndName(teamNumber);
            if (reimbursementContestVO != null) {
                reimbursementContestVO.setTeamNumber(teamNumber);

                reimbursementContestVOList.add(reimbursementContestVO);
            }
        }

        return reimbursementContestVOList;
    }

    @Override
    public List<ReimbursementRecordVO> getMyReimbursementRecord(int teamInContestId) {
        List<ReimbursementRecordVO> myReimbursementRecord = reimbursementDAO.getMyReimbursementRecord(teamInContestId);

        return myReimbursementRecord;
    }

    @Override
    public void addReimbursementRecord(int teamInContestId, String reimbursementItem, BigDecimal reimbursementAmount, int reimbursementType, String reimbursementAttachment) {
        reimbursementDAO.addReimbursementRecord(teamInContestId, reimbursementItem, reimbursementAmount, reimbursementType,
                reimbursementAttachment);
    }
}
