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
    public JsonResult getTeamInfo(@RequestParam("teamNumber")String teamNumber) {
        if (teamNumber == null || "".equals(teamNumber)) {
            return JsonResult.errorMsg("Team ID is not found.");
        }

        TeamInfoVO teamInfoVO = teamService.getTeamInfo(Integer.valueOf(teamNumber));

        if (teamInfoVO == null) {
            return JsonResult.exceptionErrorMsg("Team info is not found");
        }

        return JsonResult.ok(teamInfoVO);
    }

    @GetMapping("/getMyTeam")
    public JsonResult getMyTeam(@RequestParam("stuId")String stuId) {
        if (stuId == null || "".equals(stuId)) {
            return JsonResult.errorMsg("Your id is wrong! Please check again...");
        }

        List<MyTeamVO> myTeamList = teamService.getMyTeam(stuId);

        if (myTeamList == null || myTeamList.size() == 0) {
            return JsonResult.errorMsg("Your team is not found");
        }

        return JsonResult.ok(myTeamList);
    }

    @PostMapping("/createTeam")
    public JsonResult createTeam(@RequestBody()JSONObject team) {
        if (team == null) {
            return JsonResult.errorMsg("Team info is null..");
        }

        String teamName = team.getString("teamName");
        String captain = team.getString("captain");
        String teamInfo = team.getString("teamInfo");
        String recruitRequest = team.getString("recruitRequest");
        String workload = team.getString("workload");

        if ("".equals(teamName) || "".equals(captain) || "".equals(teamInfo) || "".equals(recruitRequest) || "".equals(workload)) {
            return JsonResult.errorMsg("Team info is wrong! Please check again..");
        }

        teamService.createTeam(teamName, captain, teamInfo, recruitRequest, workload);

        return JsonResult.ok("发布组队信息成功");
    }

    @PostMapping("/sendResume")
    public JsonResult sendResume(@RequestBody()JSONObject resumeInfo) {
        if (resumeInfo == null) {
            return JsonResult.errorMsg("Resume info is null..");
        }

        String captain = resumeInfo.getString("captain");
        String stuId = resumeInfo.getString("stuId");
        String username = resumeInfo.getString("username");
        String school = resumeInfo.getString("school");
        String department = resumeInfo.getString("department");
        String phoneNum = resumeInfo.getString("phoneNum");
        String resume = resumeInfo.getString("resume");

        if ("".equals(captain) || "".equals(username) || "".equals(stuId) || "".equals(school) || "".equals(department) ||
                "".equals(phoneNum) || "".equals(resume)) {
            return JsonResult.errorMsg("Resume Info is null..");
        }

        ResumeVO resumeVO = new ResumeVO();
        resumeVO.setStuId(stuId);
        resumeVO.setUsername(username);
        resumeVO.setSchool(school);
        resumeVO.setDepartment(department);
        resumeVO.setPhoneNum(phoneNum);
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
