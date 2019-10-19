package com.contestgo.contestgobackend.domain;

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
    private int team_number;
    /** 队伍名称 */
    private String team_name;
    /** 队长 */
    private String captain;
    /** 队长类型 */
    private int captain_type;
    /** 队伍信息 */
    private String team_info;
    /** 招募要求 */
    private String recruit_request;
    /** 工作量 */
    private String workload;
    /** 最大成员数 */
    private int max_members;
    /** 队伍状态 */
    private int team_status;
}
