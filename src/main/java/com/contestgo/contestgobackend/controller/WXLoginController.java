package com.contestgo.contestgobackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.constant.RedisConstant;
import com.contestgo.contestgobackend.bean.WXSession;
import com.contestgo.contestgobackend.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param: none
 * @description: 小程序登录获取open_id和session_key
 * @author: KingJ
 * @create: 2019-03-15 20:51
 **/
@RestController
public class WXLoginController {

    @Autowired
    private RedisUtils redis;

    @PostMapping("/wxLogin")
    public JsonResult wxLogin(@RequestBody(required = true)JSONObject codeJson) {
        String code = codeJson.getString("code");

        WXLogin wxLogin = new WXLogin();

		WXSession session = wxLogin.WXLogin(code);
        System.out.println(session);


        redis.set("user-redis-session" + session.getOpenid(),
                    session.getSessionKey(),
                    RedisConstant.EXPIRE_TIME);

        Map<String, String> result = new ConcurrentHashMap<>();
        result.put("code", code);

        return JsonResult.ok(result);
    }
}
