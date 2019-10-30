package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 09:36
 **/
@Data
public class TeamVO {
    private int teamNumber;
    /** 队伍名称 */
    private String teamName;
    /** 队伍信息 */
    private String teamInfo;
}
