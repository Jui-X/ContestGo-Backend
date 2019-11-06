package com.contestgo.contestgobackend.bean;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-16 09:53
 **/
@Data
public class WXSession {

    private String sessionKey;

    private String openid;
}
