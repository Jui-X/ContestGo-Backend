package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 10:14
 **/
@Data
public class TeamInfoVO {
    /** id */
    private int teamNumber;
    /** 队伍名称 */
    private String teamName;
    /** 队长 */
    private String captain;
    /** 队伍信息 */
    private String teamInfo;
    /** 招募要求 */
    private String recruitRequest;
    /** 工作量 */
    private String workload;
}
