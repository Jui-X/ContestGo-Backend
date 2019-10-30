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
    public TeamInfoVO getTeamInfo(int teamNumber) {
        return teamDAO.getTeamInfo(teamNumber);
    }

    @Override
    public List<MyTeamVO> getMyTeam(int stuId) {
        List<MyTeamVO> myTeamList = new ArrayList<>();

        List<Integer> teamIDList = teamDAO.getMyTeam(stuId);

        for (Integer number : teamIDList) {
            MyTeamVO myTeamVO = new MyTeamVO();
            myTeamVO.setTeamId(number);

            TeamInfoVO teamInfoVO = teamDAO.getMyTeamInfo(number);
            myTeamVO.setCaptainName(teamInfoVO.getTeamName());
            myTeamVO.setTeamInfo(teamInfoVO.getTeamInfo());
            myTeamVO.setCaptainName(teamInfoVO.getCaptain());

            myTeamVO.setTeamMembers(teamDAO.getMyTeamMembers(number));

            myTeamList.add(myTeamVO);
        }

        return myTeamList;
    }

    @Override
    public void createTeam(String teamName, String captain, String teamInfo, String recruitRequest, String workload) {
        teamDAO.createTeam(teamName, captain, teamInfo, recruitRequest, workload);
    }
}
