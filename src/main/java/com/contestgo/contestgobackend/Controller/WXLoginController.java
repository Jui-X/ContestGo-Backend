package com.contestgo.contestgobackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.contestgo.contestgobackend.Utils.HttpClientUtil;
import com.contestgo.contestgobackend.Utils.JsonResult;
import com.contestgo.contestgobackend.Utils.JsonUtils;
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
@RequestMapping("/wx")
public class WXLoginController {


    @PostMapping("/wxLogin")
    public String wxLogin(@RequestBody(required = true)JSONObject codeJson) {
        String code = codeJson.getString("code");
        System.out.println(code);

//		https://api.weixin.qq.com/sns/jscode2session?
//				appid=APPID&
//				secret=SECRET&
//				js_code=JSCODE&
//				grant_type=authorization_code

        String url =  "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wxcd637a1e509ee41c");
        param.put("secret", "c084251a0297f033762a4438b8eb6a97");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);

        Map<String, String> result = new HashMap<>();
        result.put("code", code);
//        return JsonResult.ok(code);
        return JsonUtils.objectToJson(result);
    }
}
