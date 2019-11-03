package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.ContestService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.utils.SendMailUtil;
import com.contestgo.contestgobackend.vo.ContestAttachmentVO;
import com.contestgo.contestgobackend.vo.ContestDetailVO;
import com.contestgo.contestgobackend.vo.ContestVO;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-17 12:17
 **/
@RestController
@Api(value = "比赛接口", tags = "比赛相关信息的Controller")
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private SendMailUtil sendMailService;

    @GetMapping("/listContest/scientific")
    public JsonResult listScientificContest() {
        List<ContestVO> scientificContest = contestService.listScientificContest();
        if (scientificContest != null) {
            return JsonResult.ok(scientificContest);
        } else {
            return JsonResult.errorMsg("Contest Not Found!");
        }
    }

    @GetMapping("/listContest/sport")
    public JsonResult listSportContest() {
        List<ContestVO> sportContest = contestService.listSportContest();
        if (sportContest != null) {
            return JsonResult.ok(sportContest);
        } else {
            return JsonResult.errorMsg("Contest Not Found!");
        }
    }

    @GetMapping("/getContestDetail")
    public JsonResult getContestDetail(@RequestParam("contestId")String contestId) {
        if (contestId == null || "".equals(contestId)) {
            return JsonResult.errorMsg("Contest ID is wrong!");
        }

        ContestDetailVO contestDetailVO = contestService.getContestDetail(Integer.valueOf(contestId));

        if (contestDetailVO == null) {
            return JsonResult.errorMsg("Contest is not found.");
        }

        return JsonResult.ok(contestDetailVO);
    }

    @PostMapping("/signUpContest")
    public JsonResult signUpContest(@RequestBody()JSONObject signUpInfo) {
        if (signUpInfo == null) {
            return JsonResult.errorMsg("Sign up info is null..");
        }

        int contestId = Integer.valueOf(signUpInfo.getString("contestId"));
        int teamId = Integer.valueOf(signUpInfo.getString("teamNumber"));
        int captainId = Integer.valueOf(signUpInfo.getString("captainId"));
        String captainName = signUpInfo.getString("captainName");
        String captainDepartment = signUpInfo.getString("captainDepartment");

        if (contestId <= 0 || teamId <= 0 || captainId <= 0 || "".equals(captainName) || "".equals(captainDepartment)) {
            return JsonResult.errorMsg("Sign up info is wrong, please check again!");
        }

        contestService.signUpContest(contestId, teamId, captainId, captainName, captainDepartment);

        return JsonResult.ok("报名成功～");
    }

    @PostMapping("/sendAttachment")
    public JsonResult sendMail(@RequestBody()JSONObject contestInfo) throws MessagingException {
        String receiver = contestInfo.getString("emailAddress");
        int contestId = Integer.valueOf(contestInfo.getString("contestId"));

        // 获得竞赛附件相关信息
        ContestAttachmentVO contestAttachmentVO = contestService.getContestAttachment(contestId);
        if (contestAttachmentVO == null) {
            return JsonResult.errorMsg("Contest Attachment is not found...");
        }

        sendMailService.sendContestAttachmentEmail(receiver, contestAttachmentVO);

        return JsonResult.ok("已成功发送附件～～");
    }



    /** @RequestParam("contest_name")String contestName, @RequestParam("contest_details")String contest_details,
     @RequestParam("contest_type")String contestType, @Param("apply_ddl")String apply_ddl,
     @Param("submit_ddl")String submit_ddl, @Param("preliminary")String preliminary,
     @Param("quarter_final")String quarter_final, @Param("finalDate")String finalDate,
     @RequestParam("venue")String venue, @RequestParam("attachment")MultipartFile attachment,
     @RequestParam("email_address")String emailAddress */
    @PostMapping("/create")
    /** @RequestBody(required = true)JSONObject contestInfo */
    public JsonResult createContest(@RequestParam("contestName")String contestName, @RequestParam("contest_details")String contestDetail,
                                @RequestParam("contestType")String contestType, @Param("apply_ddl")String applyDDL,
                                @Param("submit_ddl")String submitDDL, @Param("preliminary")String preliminary,
                                @Param("quarter_final")String quarterFinal, @Param("finalDate")String finalDate,
                                @RequestParam("venue")String venue, @RequestParam("attachment")List<MultipartFile> attachments,
                                @RequestParam("emailAddress")String emailAddress) {
//        String name = contestInfo.getString("name");
//        String detail = contestInfo.getString("detail");
//        String type = contestInfo.getString("type");
//        String venue = contestInfo.getString("venue");
//        Timestamp apply_ddl = contestInfo.getTimestamp("applyddl");
//        Timestamp submit_ddl = contestInfo.getTimestamp("submitddl");
//        Timestamp preliminaryDate = contestInfo.getTimestamp("preliminary");
//        Timestamp quarterFinalDate = contestInfo.getTimestamp("quarter_final");
//        Timestamp finalDate = contestInfo.getTimestamp("final");
//        String attachment = contestInfo.getString("attachment");
//        String emailAddress = contestInfo.getString("emailAddress");

//        if (attachment.isEmpty()) {return JsonResult.errorMsg("上传附件不能为空！");}
        StringBuffer paths = new StringBuffer();
        for(MultipartFile attachment: attachments) {
            String fileName = attachment.getOriginalFilename();
            String parentPath = "C:\\Users\\50131\\Documents\\GitHub\\ContestGo-Backend\\src\\main\\resources\\file";
            File file = new File(parentPath + "\\" + fileName);

            try {
                attachment.transferTo(file);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String path = file.getAbsolutePath();
            paths.append(path + "; ");
        }

//        Timestamp applyDeadline = apply_ddl == null ? null : Timestamp.valueOf(apply_ddl);
//        Timestamp submitDeadline = submit_ddl == null ? null : Timestamp.valueOf(submit_ddl);
//        Timestamp preliminaryDate = preliminary == null ? null : Timestamp.valueOf(preliminary);
//        Timestamp quarterFinalDate = quarter_final == null ? null : Timestamp.valueOf(quarter_final);
//        Timestamp date = finalDate == null ? null : Timestamp.valueOf(finalDate);

        /** name, detail, type, applyDeadline, submitDeadline, preliminaryDate,
         quarterFinalDate, date, venue, file, emailAddress */

        contestService.createContest(contestName, contestDetail, contestType, venue, paths.toString(), emailAddress);

        Map<String, String> map = new HashMap<>();
        map.put("contest_name", contestName);
        map.put("contest_details", contestDetail);
        map.put("contest_type", contestType);

        return JsonResult.ok(map);
    }
}
