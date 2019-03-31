package com.contestgo.contestgobackend.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ContestDAO {

    /** "INSERT INTO contest(name, contest_details, contest_type, apply_deadline, submit_deadline, " +
     "quarter_final_date, final_date, venue, attachment, email_address) VALUES(#{contest_name}, #{contest_details}, " +
     "#{contest_type}, #{apply_deadline}, #{submit_deadline}, #{preliminary_date}, #{quarter_final_date}, #{final_date}, " +
     "#{venue}, #{attachment}, #{email_address})" */

    /** @Param("name")String contest_name, @Param("detail")String contest_details,
     @Param("type")String contest_type, @Param("apply_deadline")Timestamp apply_deadline,
     @Param("submit_deadline")Timestamp submit_deadline, @Param("preliminary")Timestamp preliminary_date,
     @Param("quarter_final")Timestamp quarter_final_date, @Param("final")Timestamp final_date,
     @Param("venue")String venue, @Param("attachment")File attachment, @Param("email_address")String email_address */

    @Insert("INSERT INTO contest(name, contest_details, contest_type, venue, attachment, email_address) " +
            "VALUES(#{contest_name}, #{contest_details}, #{contest_type}, #{venue}, #{attachment}, #{email_address})")
    public void insertContest(@Param("contest_name")String contest_name, @Param("contest_details")String contest_details,
                              @Param("contest_type")String contest_type, @Param("venue")String venue,
                              @Param("attachment")String attachment, @Param("email_address")String email_address);
}
