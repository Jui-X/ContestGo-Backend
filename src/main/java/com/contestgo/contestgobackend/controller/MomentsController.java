package com.contestgo.contestgobackend.controller;

import com.contestgo.contestgobackend.service.MomentsService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.vo.MomentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
