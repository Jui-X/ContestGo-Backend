package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.dao.ContestDAO;
import com.contestgo.contestgobackend.service.ContestService;
import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-17 12:13
 **/
@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestDAO contestDAO;

    @Override
    public List<ContestVO> listScientificContest() {
        return contestDAO.listScientificContest();
    }

    @Override
    public List<ContestVO> listSportContest() {
        return contestDAO.listSportContest();
    }

    @Override
    public ContestDetailVO getContestDetail(int contest_id) {
        return contestDAO.getContestDetail(contest_id);
    }

    @Override
    public ContestAttachmentVO getContestAttachment(int contest_id) {
        return contestDAO.getContestAttachment(contest_id);
    }

    @Override
    public void signUpContest(int contestId, int teamId, int captainId, String captainName, String captainDepartment) {
        contestDAO.insertTeamInContest(contestId, teamId, captainId, captainName, captainDepartment);
    }

    /** String contestName, String contest_details, String contestType, Timestamp applyDeadline,
     Timestamp submitDeadline, Timestamp preliminaryDate, Timestamp quarterFinalDate,
     Timestamp finalDate, String venue, File file, String emailAddress */
    @Override
    public void createContest(String contestName, String contestDetail, String contestType,
                              String venue, String path, String emailAddress) {

        /** contestName, contest_details, contestType, applyDeadline, submitDeadline,
         preliminaryDate, quarterFinalDate, finalDate, venue, file, emailAddress */
        contestDAO.insertContest(contestName, contestDetail, contestType, venue, path, emailAddress);
    }
}
