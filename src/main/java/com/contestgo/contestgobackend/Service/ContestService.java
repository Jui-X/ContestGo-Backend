package com.contestgo.contestgobackend.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

public interface ContestService {

    /** String contest_name, String contest_details, String contest_type, Timestamp apply_deadline,
     Timestamp submit_deadline, Timestamp preliminary_date, Timestamp quarter_final_date,
     Timestamp final_date, String venue, File file, String email_address */
    public void createContest(String contest_name, String contest_details, String contest_type,
                              String venue, String path, String email_address);
}
