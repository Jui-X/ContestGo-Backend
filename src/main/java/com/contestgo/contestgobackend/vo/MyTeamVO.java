package com.contestgo.contestgobackend.vo;

import lombok.Data;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 21:07
 **/
@Data
public class MyTeamVO {
    /** 队伍ID */
    private int teamId;
    /** 队伍名称 */
    private String teamName;
    /** 队长姓名 */
    private String captainName;
    /** 队伍简介 */
    private String teamInfo;
    /** 队员信息 */
    private List<String> teamMembers;
}
