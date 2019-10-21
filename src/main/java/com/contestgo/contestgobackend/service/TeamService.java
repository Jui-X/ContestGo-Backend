package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.MyTeamVO;
import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;

import java.util.List;

public interface TeamService {
    List<TeamVO> getTeam();

    TeamInfoVO getTeamInfo(int team_number);

    List<MyTeamVO> getMyTeam(int stu_id);

    void createTeam(String team_name, String captain, String team_info, String recruit_request, String workload);
}
