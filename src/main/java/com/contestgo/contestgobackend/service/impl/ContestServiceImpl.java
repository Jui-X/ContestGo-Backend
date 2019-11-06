package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.dao.ContestDAO;
import com.contestgo.contestgobackend.dao.TeamDAO;
import com.contestgo.contestgobackend.service.ContestService;
import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;
import com.contestgo.contestgobackend.vo.MyContestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<ContestVO> listScientificContest() {
        return contestDAO.listScientificContest();
    }

    @Override
    public List<ContestVO> listSportContest() {
        return contestDAO.listSportContest();
    }

    @Override
    public List<MyContestVO> getMyContest(String stuId) {
        List<Integer> myTeam = teamDAO.getMyTeam(stuId);

        List<MyContestVO> myContestVOList = new ArrayList<>();
        for (Integer teamNumber : myTeam) {
            MyContestVO myContest = contestDAO.getMyContest(teamNumber);

            if (myContest != null) {
                myContestVOList.add(myContest);
            }
        }

        return myContestVOList;
    }

    @Override
    public ContestDetailVO getContestDetail(int contestId) {
        return contestDAO.getContestDetail(contestId);
    }

    @Override
    public ContestAttachmentVO getContestAttachment(int contestId) {
        return contestDAO.getContestAttachment(contestId);
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
