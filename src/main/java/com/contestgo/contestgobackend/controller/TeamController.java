package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.StudentService;
import com.contestgo.contestgobackend.service.TeamService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.utils.SendMailUtil;
import com.contestgo.contestgobackend.vo.MyTeamVO;
import com.contestgo.contestgobackend.vo.ResumeVO;
import com.contestgo.contestgobackend.vo.TeamInfoVO;
import com.contestgo.contestgobackend.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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

    @Autowired
    private StudentService studentService;

    @Autowired
    private SendMailUtil sendMailService;

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

    @PostMapping("/sendResume")
    public JsonResult sendResume(@RequestBody()JSONObject resumeInfo) {
        if (resumeInfo == null) {
            return JsonResult.errorMsg("Resume info is null..");
        }

        String captain = resumeInfo.getString("captain");
        String stu_id = resumeInfo.getString("stu_id");
        String username = resumeInfo.getString("username");
        String school = resumeInfo.getString("school");
        String department = resumeInfo.getString("department");
        String phone_num = resumeInfo.getString("phone_num");
        String resume = resumeInfo.getString("resume");

        if ("".equals(captain) || "".equals(username) || "".equals(stu_id) || "".equals(school) || "".equals(department) ||
                "".equals(phone_num) || "".equals(resume)) {
            return JsonResult.errorMsg("Resume Info is null..");
        }

        ResumeVO resumeVO = new ResumeVO();
        resumeVO.setStu_id(stu_id);
        resumeVO.setUsername(username);
        resumeVO.setSchool(school);
        resumeVO.setDepartment(department);
        resumeVO.setPhone_num(phone_num);
        resumeVO.setResume(resume);

        String email = studentService.queryUserEmailByName(captain);
        if (email != null) {
            try {
                sendMailService.sendResume(email, resumeVO);
            } catch (MessagingException e) {
                return JsonResult.exceptionErrorMsg("Send email failed..");
            }
        }

        return JsonResult.ok("发送邮件成功～");
    }
}
