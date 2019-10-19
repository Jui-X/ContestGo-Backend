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
    private int team_id;
    /** 队伍名称 */
    private String team_name;
    /** 队长姓名 */
    private String captain_name;
    /** 队伍简介 */
    private String team_info;
    /** 队员信息 */
    private List<String> team_members;
}
