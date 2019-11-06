package com.contestgo.contestgobackend.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-04 16:35
 **/
@Data
public class MyContestVO {
    /** 竞赛名称 */
    private String contestName;
    /** 竞赛开始时间 */
    private Date startTime;
    /** 竞赛结束时间 */
    private Date endTime;
}
