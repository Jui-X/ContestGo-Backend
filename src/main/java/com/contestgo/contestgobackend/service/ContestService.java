package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;
import com.contestgo.contestgobackend.vo.MyContestVO;

import java.util.List;

public interface ContestService {

    /** String contestName, String contestDetail, String contestType, Timestamp applyDeadline,
     Timestamp submitDeadline, Timestamp preliminaryDate, Timestamp quarterFinalDate,
     Timestamp finalDate, String venue, File file, String emailAddress */
    void createContest(String contestName, String contestDetail, String contestType,
                              String venue, String path, String emailAddress);

    List<ContestVO> listScientificContest();

    List<ContestVO> listSportContest();

    List<MyContestVO> getMyContest(String stuId);

    ContestDetailVO getContestDetail(int contestId);

    ContestAttachmentVO getContestAttachment(int contestId);

    void signUpContest(int contestId, int teamId, int captainId, String captainName, String captainDepartment);
}
