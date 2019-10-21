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
    private String contest_name;

    /** 比赛详情 */
    private String contest_detail;

    /** 报名截止日期 */
    private Timestamp apply_deadline;

    /** 材料提交截止日期 */
    private Timestamp submit_deadline;

    /** 比赛联系人 */
    private String contest_contact;

    /** 邮箱地址 */
    private String email_address;

    /** 封面图 */
    private String cover_img;
}
