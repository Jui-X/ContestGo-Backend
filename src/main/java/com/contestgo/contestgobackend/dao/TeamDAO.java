package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeamDAO {
    @Select("SELECT team_number, team_name, team_info FROM team")
    List<TeamVO> getTeam();

    @Select("SELECT team_number, team_name, captain, team_info, recruit_request FROM team WHERE team_number = #{team_number}")
    TeamInfoVO getTeamInfo(@Param("team_number")int team_number);

    @Select("SELECT team_id FROM stu_in_team WHERE stu_id = #{stu_id}")
    List<Integer> getMyTeam(@Param("stu_id")int stu_id);

    @Select("SELECT team_name, captain, team_info FROM team WHERE team_number = #{team_number}")
    TeamInfoVO getMyTeamInfo(@Param("team_number")int team_number);

    @Select("SELECT stu_name FROM stu_in_team WHERE team_number = #{team_number}")
    List<String> getMyTeamMembers(@Param("team_number")int team_number);

    @Insert("INSERT INTO team(team_name, captain, team_info, recruit_request, workload)" +
            "VALUES(#{team_name}, #{captain}, #{team_info}, #{recruit_request}, #{workload})")
    void createTeam(@Param("team_name")String team_name, @Param("captain")String captain, @Param("team_info")String team_info,
                    @Param("recruit_request")String recruit_request, @Param("workload")String workload);
}
