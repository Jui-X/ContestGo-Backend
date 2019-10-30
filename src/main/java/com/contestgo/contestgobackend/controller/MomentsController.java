package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.service.MomentsService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.vo.MomentsContentVO;
import com.contestgo.contestgobackend.vo.MomentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 18:28
 **/
@RestController
@RequestMapping("/moments")
public class MomentsController {

    @Autowired
    private MomentsService momentsService;

    @GetMapping("/getMoments")
    public JsonResult getMoments() {
        List<MomentsVO> momentsVOList = momentsService.getMoments();

        if (momentsVOList == null) {
            return JsonResult.errorMsg("Moments are not found.");
        }

        return JsonResult.ok(momentsVOList);
    }

    @GetMapping("/getMomentsContent")
    public JsonResult getMomentsContent(@RequestParam("moments_id")String momentsId) {
        if (momentsId == null || "".equals(momentsId)) {
            return JsonResult.errorMsg("Moments id is wrong, please check again..");
        }

        MomentsContentVO momentsContent = momentsService.getMomentsContent(Integer.valueOf(momentsId));

        if (momentsContent == null) {
            return JsonResult.errorMsg("Moments is not found");
        }

        return JsonResult.ok(momentsContent);
    }

    @PostMapping("/postMoments")
    public JsonResult postMoments(@RequestBody()JSONObject moments) {
        if (moments == null) {
            return JsonResult.errorMsg("Moments data is null, please check again!");
        }

        String momentsTitle = moments.getString("moments_title");
        String momentsPublisher = moments.getString("moments_publisher");
        String momentsContent = moments.getString("moments_content");

        if ("".equals(momentsTitle) || "".equals(momentsPublisher) || "".equals(momentsContent)) {
            return JsonResult.errorMsg("Moments data is wrong..");
        }

        momentsService.postMoments(momentsTitle, momentsPublisher, momentsContent);

        return JsonResult.ok("已成功发布动态～");
    }
}
