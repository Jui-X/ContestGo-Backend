package com.contestgo.contestgobackend.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-15 20:14
 **/
@Data
public class Contest {

    /** 比赛名称 */
    private String contestName;

    /** 比赛详情 */
    private String contestDetail;

    /** 比赛类型 */
    private String contestType;

    /** 报名截止日期 */
    private Timestamp applyDeadline;

    /** 材料提交截止日期 */
    private Timestamp submitDeadline;

    /** 比赛状态 */
    private int contestStatus;

    /** 初赛日期 */
    private Timestamp preliminaryDate;

    /** 复赛日期 */
    private Timestamp quarterFinalDate;

    /** 决赛日期 */
    private Timestamp finalDate;

    /** 比赛联系人 */
    private String contestContact;

    /** 邮箱地址 */
    private String emailAddress;

    /** 比赛地点 */
    private String venue;

    /** 比赛附件 */
    private String attachment;
}
