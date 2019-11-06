package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.ReimbursementService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.vo.ReimbursementContestVO;
import com.contestgo.contestgobackend.vo.ReimbursementRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-05 15:47
 **/
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    @Autowired
    private ReimbursementService reimbursementService;

    @GetMapping("/listMyReimbursementContest")
    public JsonResult listMyReimbursementContest(@RequestParam("stuId")String stuId) {
        if (stuId == null || "".equals(stuId)) {
            return JsonResult.errorMsg("stu ID is null..");
        }

        List<ReimbursementContestVO> reimbursementContestVOList = reimbursementService.listMyReimbursementContest(stuId);
        if (reimbursementContestVOList == null) {
            return JsonResult.exceptionErrorMsg("Reimbursement contest is null..");
        }

        return JsonResult.ok(reimbursementContestVOList);
    }

    @GetMapping("/getMyReimbursementRecord")
    public JsonResult getMyReimbursementRecord(@RequestParam("teamInContestId")String teamInContestId) {
        if (teamInContestId == null || "".equals(teamInContestId)) {
            return JsonResult.errorMsg("Team In Contest ID is wrong..");
        }

        List<ReimbursementRecordVO> myReimbursementRecord = reimbursementService.getMyReimbursementRecord(Integer.valueOf(teamInContestId));

        if (myReimbursementRecord == null) {
            return JsonResult.exceptionErrorMsg("My reimbursement record is null..");
        }

        return JsonResult.ok(myReimbursementRecord);
    }

    @PostMapping("/addReimbursementRecord")
    public JsonResult addReimbursementRecord(@RequestBody()JSONObject reimbursementRecord) {
        if (reimbursementRecord == null) {
            return JsonResult.errorMsg("Reimbursement record is null..");
        }

        int teamInContestId = reimbursementRecord.getIntValue("teamInContestId");
        String reimbursementItem = reimbursementRecord.getString("reimbursementItem");
        BigDecimal reimbursementAmount = reimbursementRecord.getBigDecimal("reimbursementAmount");
        int reimbursementType = reimbursementRecord.getIntValue("reimbursementType");
        String reimbursementAttachment = reimbursementRecord.getString("reimbursementAttachment");

        reimbursementService.addReimbursementRecord(teamInContestId, reimbursementItem, reimbursementAmount, reimbursementType,
                reimbursementAttachment);

        return JsonResult.ok("Add Reimbursement Record succeed!");
    }
}
