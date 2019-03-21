package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.Constant.RedisConstant;
import com.contestgo.contestgobackend.Pojo.WXSession;
import com.contestgo.contestgobackend.Utils.HttpClientUtil;
import com.contestgo.contestgobackend.Utils.JsonResult;
import com.contestgo.contestgobackend.Utils.JsonUtils;
import com.contestgo.contestgobackend.Utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @param: none
 * @description:
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
//        System.out.println(code);

		/**
		 *
		 * https://api.weixin.qq.com/sns/jscode2session?
         * 				appid=APPID&
         * 				secret=SECRET&
         * 				js_code=JSCODE&
         * 				grant_type=authorization_code
		 *
		 **/


        String url =  "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wxcd637a1e509ee41c");
        param.put("secret", "c084251a0297f033762a4438b8eb6a97");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);

        WXSession session = JsonUtils.jsonToPojo(wxResult, WXSession.class);

        redis.set("user-redis-session" + session.getOpenid(),
                    session.getSession_key(),
                    RedisConstant.EXPIRE_TIME);

        Map<String, String> result = new HashMap<>();
        result.put("code", code);

        return JsonResult.ok(result);
    }
}
