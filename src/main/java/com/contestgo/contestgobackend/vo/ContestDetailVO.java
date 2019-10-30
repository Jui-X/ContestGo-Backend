package com.contestgo.contestgobackend.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-18 19:24
 **/
@Data
public class ContestDetailVO {
    /** 比赛名称 */
    private String contestName;

    /** 比赛详情 */
    private String contestDetail;

    /** 报名截止日期 */
    private Timestamp applyDeadline;

    /** 材料提交截止日期 */
    private Timestamp submitDeadline;

    /** 比赛联系人 */
    private String contestContact;

    /** 邮箱地址 */
    private String emailAddress;

    /** 封面图 */
    private String coverImg;
}
