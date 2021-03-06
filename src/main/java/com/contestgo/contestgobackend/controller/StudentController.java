package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.bean.Student;
import com.contestgo.contestgobackend.constant.RedisConstant;
import com.contestgo.contestgobackend.service.StudentService;
import com.contestgo.contestgobackend.utils.JsonResult;
import com.contestgo.contestgobackend.utils.MD5Utils;
import com.contestgo.contestgobackend.utils.RedisUtils;
import com.contestgo.contestgobackend.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-06 19:48
 **/
@RestController
@Api(value = "学生用户接口", tags = "学生用户的Controller")
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private MD5Utils tokenGenerator;

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "用户注册", notes = "用户通过填写用户名密码注册")
    @PostMapping("/signUp")
    public JsonResult signUp(@RequestBody(required = true)JSONObject userInfo) {
        String username = userInfo.getString("username");
        String password = userInfo.getString("password");

        Student currentUser = studentService.queryUserByName(username);
        if(currentUser == null) {
            String token = tokenGenerator.tokenGenerate(username, password);
            studentService.createUser(username, password);
            redisUtils.set(username, token, RedisConstant.EXPIRE_TIME);
            redisUtils.set(token, username, RedisConstant.EXPIRE_TIME);
        }

        Map<String, String> map = new HashMap<>();
        map.put("username", username);

        return JsonResult.ok(map);
    }

    @ApiOperation(value = "用户登录", notes = "核对用户账号密码")
    @PostMapping("/signIn")
    public JsonResult SignIn(@RequestBody(required = true)JSONObject userInfo) {
        String username = userInfo.getString("username");
        String password = userInfo.getString("password");

        Student currentUser = studentService.queryUserByName(username);
        if(!currentUser.getPassword().equals(password)) {
            return JsonResult.errorMsg("用户名或密码出错，请检查...");
        } else {
            StudentVO studentVO = new StudentVO();
            studentVO.setUsername(username);
            return JsonResult.ok(studentVO);
        }
    }
}
