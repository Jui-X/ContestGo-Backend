package com.contestgo.contestgobackend.utils;

import com.contestgo.contestgobackend.domain.WXSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @param: none
 * @description: 小程序登录获取open_id和session_key
 * @author: KingJ
 * @create: 2019-03-31 21:36
 **/
public class WXLogin {

    public WXSession WXLogin(String code) {
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

        WXSession session = JsonUtils.jsonToPojo(wxResult, WXSession.class);

        return session;
    }
}
