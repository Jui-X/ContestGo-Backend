package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-05 17:49
 **/
@Data
public class ReimbursementContestVO {
    private int teamInContestId;
    /** 比赛ID */
    private int contestId;
    /** 比赛名称 */
    private String contestName;
    /** 队伍ID */
    private int teamNumber;
}
