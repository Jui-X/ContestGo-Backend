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

    /** String contest_name, String contest_details, String contest_type, Timestamp apply_deadline,
     Timestamp submit_deadline, Timestamp preliminary_date, Timestamp quarter_final_date,
     Timestamp final_date, String venue, File file, String email_address */
    @Override
    public void createContest(String contest_name, String contest_details, String contest_type,
                              String venue, String path, String email_address) {

        /** contest_name, contest_details, contest_type, apply_deadline, submit_deadline,
         preliminary_date, quarter_final_date, final_date, venue, file, email_address */
        contestDAO.insertContest(contest_name, contest_details, contest_type, venue, path, email_address);
    }

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
    public void signUpContest(int contest_id, int team_id, int captain_id, String captain_name, String captain_department) {
        contestDAO.insertTeamInContest(contest_id, team_id, captain_id, captain_name, captain_department);
    }


}
