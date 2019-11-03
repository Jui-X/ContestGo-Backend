package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeamDAO {
    @Select("SELECT team_number, team_name, team_info FROM team")
    @Results({@Result(column = "team_number", property = "teamNumber", id =true),
              @Result(column = "team_name", property = "teamName"),
              @Result(column = "team_info", property = "teamInfo")})
    List<TeamVO> getTeam();

    @Select("SELECT team_number, team_name, captain, team_info, recruit_request FROM team WHERE team_number = #{team_number}")
    @Results({@Result(column = "team_number", property = "teamNumber", id =true),
              @Result(column = "team_name", property = "teamName"),
              @Result(column = "captain", property = "captain"),
              @Result(column = "team_info", property = "teamInfo"),
              @Result(column = "recruit_request", property = "recruitRequest")})
    TeamInfoVO getTeamInfo(@Param("team_number")int teamNumber);

    @Select("SELECT team_number FROM stu_in_team WHERE stu_id = #{stu_id}")
    List<Integer> getMyTeam(@Param("stu_id")String stuId);

    @Select("SELECT team_number, team_name, captain, team_info FROM team WHERE team_number = #{team_number}")
    @Results({@Result(column = "team_number", property = "teamNumber", id =true),
              @Result(column = "team_name", property = "teamName"),
              @Result(column = "captain", property = "captain"),
              @Result(column = "team_info", property = "teamInfo")})
    TeamInfoVO getMyTeamInfo(@Param("team_number")int teamNumber);

    @Select("SELECT stu_name FROM stu_in_team WHERE team_number = #{team_number}")
    List<String> getMyTeamMembers(@Param("team_number")int teamNumber);

    @Insert("INSERT INTO team(team_name, captain, team_info, recruit_request, workload)" +
            "VALUES(#{team_name}, #{captain}, #{team_info}, #{recruit_request}, #{workload})")
    void createTeam(@Param("team_name")String teamName, @Param("captain")String captain, @Param("team_info")String teamInfo,
                    @Param("recruit_request")String recruitRequest, @Param("workload")String workload);
}
