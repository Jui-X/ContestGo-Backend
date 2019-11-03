package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.MyTeamVO;
import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;

import java.util.List;

public interface TeamService {
    List<TeamVO> getTeam();

    TeamInfoVO getTeamInfo(int teamNumber);

    List<MyTeamVO> getMyTeam(String stuId);

    void createTeam(String teamName, String captain, String teamInfo, String recruitRequest, String workload);
}
