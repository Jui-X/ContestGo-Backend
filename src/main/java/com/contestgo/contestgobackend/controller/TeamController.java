package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.TeamService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.vo.MyTeamVO;
import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 10:01
 **/
@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/getTeam")
    public JsonResult getTeam() {
        List<TeamVO> teamVO = teamService.getTeam();

        if (teamVO == null) {
            return JsonResult.errorMsg("Team is not found.");
        }

        return JsonResult.ok(teamVO);
    }

    @GetMapping("/getTeamInfo")
    public JsonResult getTeamInfo(@RequestParam("team_number")String team_number) {
        if (team_number == null || "".equals(team_number)) {
            return JsonResult.errorMsg("Team ID is not found.");
        }

        TeamInfoVO teamInfoVO = teamService.getTeamInfo(Integer.valueOf(team_number));

        if (teamInfoVO == null) {
            return JsonResult.exceptionErrorMsg("Team info is not found");
        }

        return JsonResult.ok(teamInfoVO);
    }

    @GetMapping("/getMyTeam")
    public JsonResult getMyTeam(@RequestParam("stu_id")String stu_id) {
        if (stu_id == null || "".equals(stu_id)) {
            return JsonResult.errorMsg("Your id is wrong! Please check again...");
        }

        List<MyTeamVO> myTeamList = teamService.getMyTeam(Integer.valueOf(stu_id));

        if (myTeamList == null || myTeamList.size() == 0) {
            return JsonResult.errorMsg("Your team is not found");
        }

        return JsonResult.ok(myTeamList);
    }

    @PostMapping("/createTeam")
    public JsonResult createTeam(@RequestBody()JSONObject teamInfo) {
        if (teamInfo == null) {
            return JsonResult.errorMsg("Team info is null..");
        }

        String team_name = teamInfo.getString("team_name");
        String captain = teamInfo.getString("captain");
        String team_info = teamInfo.getString("team_info");
        String recruit_request = teamInfo.getString("recruit_request");
        String workload = teamInfo.getString("workload");

        if ("".equals(team_name) || "".equals(captain) || "".equals(team_info) || "".equals(recruit_request) || "".equals(workload)) {
            return JsonResult.errorMsg("Team info is wrong! Please check again..");
        }

        teamService.createTeam(team_name, captain, team_info, recruit_request, workload);

        return JsonResult.ok("发布组队信息成功");
    }
}
