package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;

import java.util.List;

public interface ContestService {

    /** String contest_name, String contest_details, String contest_type, Timestamp apply_deadline,
     Timestamp submit_deadline, Timestamp preliminary_date, Timestamp quarter_final_date,
     Timestamp final_date, String venue, File file, String email_address */
    void createContest(String contest_name, String contest_details, String contest_type,
                              String venue, String path, String email_address);

    List<ContestVO> listScientificContest();

    List<ContestVO> listSportContest();

    ContestDetailVO getContestDetail(int contest_id);

    ContestAttachmentVO getContestAttachment(int contest_id);

    void signUpContest(int contest_id, int team_id, int captain_id, String captain_name, String captain_department);
}