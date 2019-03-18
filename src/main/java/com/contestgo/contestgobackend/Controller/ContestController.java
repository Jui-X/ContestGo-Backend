package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.Service.ContestService;
import com.contestgo.contestgobackend.Utils.JsonResult;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-17 12:17
 **/
@Controller
@Api(value = "比赛接口", tags = "比赛相关信息的Controller")
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private ContestService contestService;

    /** @RequestParam("contest_name")String contest_name, @RequestParam("contest_details")String contest_details,
     @RequestParam("contest_type")String contest_type, @Param("apply_ddl")String apply_ddl,
     @Param("submit_ddl")String submit_ddl, @Param("preliminary")String preliminary,
     @Param("quarter_final")String quarter_final, @Param("final_date")String final_date,
     @RequestParam("venue")String venue, @RequestParam("attachment")MultipartFile attachment,
     @RequestParam("email_address")String email_address */
    @ResponseBody
    @PostMapping("/create")
    /** @RequestBody(required = true)JSONObject contestInfo */
    public JsonResult createContest(@RequestParam("contest_name")String contest_name, @RequestParam("contest_details")String contest_details,
                                @RequestParam("contest_type")String contest_type, @Param("apply_ddl")String apply_ddl,
                                @Param("submit_ddl")String submit_ddl, @Param("preliminary")String preliminary,
                                @Param("quarter_final")String quarter_final, @Param("final_date")String final_date,
                                @RequestParam("venue")String venue, @RequestParam("attachment")List<MultipartFile> attachments,
                                @RequestParam("email_address")String email_address) {
//        String name = contestInfo.getString("name");
//        String detail = contestInfo.getString("detail");
//        String type = contestInfo.getString("type");
//        String venue = contestInfo.getString("venue");
//        Timestamp apply_ddl = contestInfo.getTimestamp("applyddl");
//        Timestamp submit_ddl = contestInfo.getTimestamp("submitddl");
//        Timestamp preliminary_date = contestInfo.getTimestamp("preliminary");
//        Timestamp quarter_final_date = contestInfo.getTimestamp("quarter_final");
//        Timestamp final_date = contestInfo.getTimestamp("final");
//        String attachment = contestInfo.getString("attachment");
//        String email_address = contestInfo.getString("email_address");

//        if (attachment.isEmpty()) {return JsonResult.errorMsg("上传附件不能为空！");}
        StringBuffer paths = new StringBuffer();
        for(MultipartFile attachment: attachments) {
            String fileName = attachment.getOriginalFilename();
            String parent_path = "C:\\Users\\50131\\Documents\\GitHub\\ContestGo-Backend\\src\\main\\resources\\file";
            File file = new File(parent_path + "\\" + fileName);

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

//        Timestamp apply_deadline = apply_ddl == null ? null : Timestamp.valueOf(apply_ddl);
//        Timestamp submit_deadline = submit_ddl == null ? null : Timestamp.valueOf(submit_ddl);
//        Timestamp preliminary_date = preliminary == null ? null : Timestamp.valueOf(preliminary);
//        Timestamp quarter_final_date = quarter_final == null ? null : Timestamp.valueOf(quarter_final);
//        Timestamp date = final_date == null ? null : Timestamp.valueOf(final_date);

        /** name, detail, type, apply_deadline, submit_deadline, preliminary_date,
         quarter_final_date, date, venue, file, email_address */

        contestService.createContest(contest_name, contest_details, contest_type, venue, paths.toString(), email_address);

        Map<String, String> map = new HashMap<>();
        map.put("contest_name", contest_name);
        map.put("contest_details", contest_details);
        map.put("contest_type", contest_type);

        return JsonResult.ok(map);
    }
}
