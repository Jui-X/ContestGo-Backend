package com.contestgo.contestgobackend.DO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-16 09:53
 **/
@Data
public class WXSession {

    private String session_key;

    private String openid;
}
