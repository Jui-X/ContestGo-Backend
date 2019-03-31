package com.contestgo.contestgobackend.DO;

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
    private String contest_name;

    /** 比赛详情 */
    private String contest_details;

    /** 比赛类型 */
    private String contest_type;

    /** 报名截止日期 */
    private Timestamp apply_deadline;

    /** 材料提交截止日期 */
    private Timestamp submit_deadline;

    /** 初赛日期 */
    private Timestamp preliminary_date;

    /** 复赛日期 */
    private Timestamp quarter_final_date;

    /** 决赛日期 */
    private Timestamp final_date;

    /** 比赛地点 */
    private String venue;

    /** 比赛附件 */
    private String attachment;

    /** 邮箱地址 */
    private String email_address;

    /** 比赛状态 */
    private int contest_status;
}
