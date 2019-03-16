package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.Pojo.User;
import com.contestgo.contestgobackend.Constant.RedisConstant;
import com.contestgo.contestgobackend.Service.UserService;
import com.contestgo.contestgobackend.Utils.JsonResult;
import com.contestgo.contestgobackend.Utils.MD5Utils;
import com.contestgo.contestgobackend.Utils.RedisUtils;
import com.contestgo.contestgobackend.VO.UserVO;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private MD5Utils tokenGenerator;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户通过填写用户名密码注册")
    @PostMapping("/signUp")
    public JsonResult signUp(@RequestParam("username")String username, @RequestParam("password")String password) {
//        String username = userInfo.getString("username");
//        String password = userInfo.getString("password");

        User currentUser = userService.queryUserByName(username);
        if(currentUser == null) {
            String token = tokenGenerator.tokenGenerate(username, password);
            userService.createUser(username, password);
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
        String passwrod = userInfo.getString("password");

        User currentUser = userService.queryUserByName(username);
        if(!currentUser.getPassword().equals(passwrod)) {
            return JsonResult.errorMsg("用户名或密码出错，请检查...");
        } else {
            UserVO userVO = new UserVO();
            userVO.setUsername(username);
            return JsonResult.ok(userVO);
        }
    }

    @GetMapping("/test")
    public String test() {
        return "index";
    }

}
