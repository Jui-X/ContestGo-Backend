package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContestDAO {

    @Select("SELECT contest_id, contest_name FROM contest WHERE contest_type = ${@com.contestgo.contestgobackend.enums.ContestEnum@SCIENTIFIC_CONTEST.getType()}")
    List<ContestVO> listScientificContest();

    @Select("SELECT contest_id, contest_name FROM contest WHERE contest_type = ${@com.contestgo.contestgobackend.enums.ContestEnum@SPORT_CONTEST.getType()}")
    List<ContestVO> listSportContest();

    @Select("SELECT contest_id, contest_name, contest_detail, apply_deadline, submit_deadline, contest_contact, email_address, " +
            "cover_img FROM contest WHERE contest_id = #{contest_id}")
    ContestDetailVO getContestDetail(@Param("contest_id")int contestId);

    @Select("SELECT contest_name, attachment FROM contest WHERE contest_id = #{contest_id}")
    ContestAttachmentVO getContestAttachment(@Param("contest_id")int contestId);

    @Insert("INSERT INTO team_in_contest(contest_id, team_id, captain_id, captain_name, captain_department) " +
            "VALUES(#{contest_id}, #{team_id}, #{captain_id}, #{captain_name}, #{captain_department})")
    void insertTeamInContest(@Param("contest_id")int contestId, @Param("team_id")int teamId,
                             @Param("captain_id")int captainId, @Param("captain_name")String captainName,
                             @Param("captain_department")String captainDepartment);



    /** "INSERT INTO contest(name, contest_details, contestType, apply_deadline, submit_deadline, " +
     "quarter_final_date, final_date, venue, attachment, email_address) VALUES(#{contestName}, #{contest_details}, " +
     "#{contest_type}, #{apply_deadline}, #{submit_deadline}, #{preliminary_date}, #{quarter_final_date}, #{final_date}, " +
     "#{venue}, #{attachment}, #{email_address})" */

    /** @Param("name")String contestName, @Param("detail")String contest_details,
     @Param("type")String contestType, @Param("apply_deadline")Timestamp apply_deadline,
     @Param("submit_deadline")Timestamp submit_deadline, @Param("preliminary")Timestamp preliminary_date,
     @Param("quarter_final")Timestamp quarter_final_date, @Param("final")Timestamp final_date,
     @Param("venue")String venue, @Param("attachment")File attachment, @Param("email_address")String email_address */

    @Insert("INSERT INTO contest(contest_name, contest_detail, contest_type, venue, attachment, email_address) " +
            "VALUES(#{contest_name}, #{contest_details}, #{contest_type}, #{venue}, #{attachment}, #{email_address})")
    void insertContest(@Param("contest_name")String contestName, @Param("contest_details")String contestDetails,
                       @Param("contest_type")String contestType, @Param("venue")String venue,
                       @Param("attachment")String attachment, @Param("emailAddress")String emailAddress);
}
