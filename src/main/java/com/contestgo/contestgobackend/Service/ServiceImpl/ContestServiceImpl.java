package com.contestgo.contestgobackend.Service.ServiceImpl;

import com.contestgo.contestgobackend.Mapper.ContestMapper;
import com.contestgo.contestgobackend.Service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
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
    private ContestMapper contestMapper;

    /** String contest_name, String contest_details, String contest_type, Timestamp apply_deadline,
     Timestamp submit_deadline, Timestamp preliminary_date, Timestamp quarter_final_date,
     Timestamp final_date, String venue, File file, String email_address */
    @Override
    public void createContest(String contest_name, String contest_details, String contest_type,
                              String venue, String path, String email_address) {

        /** contest_name, contest_details, contest_type, apply_deadline, submit_deadline,
         preliminary_date, quarter_final_date, final_date, venue, file, email_address */
        contestMapper.insertContest(contest_name, contest_details, contest_type, venue, path, email_address);
    }
}
