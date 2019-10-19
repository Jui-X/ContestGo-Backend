package com.contestgo.contestgobackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-17 14:41
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping()
    public String index() {return "form";}
}
