package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContestDAO {

    @Select("SELECT contest_id, contest_name FROM contest WHERE contest_type = ${@com.contestgo.contestgobackend.enums.ContestEnum@SCIENTIFIC_CONTEST.getType()}")
    @Results({@Result(column = "contest_id", property = "contestId", id =true),
            @Result(column = "contest_name", property = "contestName")})
    List<ContestVO> listScientificContest();

    @Select("SELECT contest_id, contest_name FROM contest WHERE contest_type = ${@com.contestgo.contestgobackend.enums.ContestEnum@SPORT_CONTEST.getType()}")
    @Results({@Result(column = "contest_id", property = "contestId", id =true),
            @Result(column = "contest_name", property = "contestName")})
    List<ContestVO> listSportContest();

    @Select("SELECT contest_name, start_time, end_time FROM team_in_contest WHERE team_number=#{team_number}")
    @Results({@Result(column = "contest_name", property = "contestName"),
              @Result(column = "start_time", property = "startTime"),
              @Result(column = "end_time", property = "endTime")})
    MyContestVO getMyContest(@Param("team_number") int teamNumber);

    @Select("SELECT team_in_contest_id, contest_id, contest_name FROM team_in_contest WHERE team_number = #{team_number}")
    @Results({@Result(column = "team_in_contest_id", property = "teamInContestId", id = true),
              @Result(column = "contest_id", property = "contestId"),
              @Result(column = "contest_name", property = "contestName")
    })
    ReimbursementContestVO getMyContestIdAndName(@Param("team_number")int teamNumber);

    @Select("SELECT contest_id, contest_name, contest_detail, apply_deadline, submit_deadline, contest_contact, email_address, " +
            "cover_img FROM contest WHERE contest_id = #{contest_id}")
    @Results({@Result(column = "contest_id", property = "contestId", id =true),
              @Result(column = "contest_name", property = "contestName"),
              @Result(column = "contest_detail", property = "contestDetail"),
              @Result(column = "apply_deadline", property = "applyDeadline"),
              @Result(column = "submit_deadline", property = "submitDeadline"),
              @Result(column = "contest_contact", property = "contestContact"),
              @Result(column = "email_address", property = "emailAddress"),
              @Result(column = "cover_img", property = "coverImg")})
    ContestDetailVO getContestDetail(@Param("contest_id")int contestId);

    @Select("SELECT contest_name, attachment FROM contest WHERE contest_id = #{contest_id}")
    @Results({@Result(column = "contest_name", property = "contestName"),
            @Result(column = "attachment", property = "attachment")})
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
