package com.contestgo.contestgobackend.service.impl;

import com.contestgo.contestgobackend.dao.TeamDAO;
import com.contestgo.contestgobackend.service.TeamService;
import com.contestgo.contestgobackend.vo.MyTeamVO;
import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 09:59
 **/
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<TeamVO> getTeam() {
        return teamDAO.getTeam();
    }

    @Override
    public TeamInfoVO getTeamInfo(int team_number) {
        return teamDAO.getTeamInfo(team_number);
    }

    @Override
    public List<MyTeamVO> getMyTeam(int team_number) {
        List<MyTeamVO> myTeamList = new ArrayList<>();

        List<Integer> teamIDList = teamDAO.getMyTeam(team_number);

        for (Integer number : teamIDList) {
            MyTeamVO myTeamVO = new MyTeamVO();
            myTeamVO.setTeam_id(number);

            TeamInfoVO teamInfoVO = teamDAO.getMyTeamInfo(number);
            myTeamVO.setTeam_name(teamInfoVO.getTeam_name());
            myTeamVO.setTeam_info(teamInfoVO.getTeam_info());
            myTeamVO.setCaptain_name(teamInfoVO.getCaptain());

            myTeamVO.setTeam_members(teamDAO.getMyTeamMembers(number));

            myTeamList.add(myTeamVO);
        }

        return myTeamList;
    }

    @Override
    public void createTeam(String team_name, String captain, String team_info, String recruit_request, String workload) {
        teamDAO.createTeam(team_name, captain, team_info, recruit_request, workload);
    }
}
