package com.contestgo.contestgobackend.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 09:36
 **/
@Data
@ApiModel(value = "队伍", description = "队伍信息")
public class Team {
    /** id */
    private int teamNumber;
    /** 队伍名称 */
    private String teamName;
    /** 队长 */
    private String captain;
    /** 队长类型 */
    private int captainType;
    /** 队伍信息 */
    private String teamInfo;
    /** 招募要求 */
    private String recruitRequest;
    /** 工作量 */
    private String workload;
    /** 最大成员数 */
    private int maxMembers;
    /** 队伍状态 */
    private int teamStatus;
}
