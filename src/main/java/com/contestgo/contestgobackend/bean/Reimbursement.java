package com.contestgo.contestgobackend.bean;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-05 15:49
 **/
@Data
public class Reimbursement {
    private int reimbursementId;
    /** 比赛ID */
    private int contestId;
    /** 队伍ID */
    private int teamId;
    /** 报销物品 */
    private String reimbursementItem;
    /** 报销金额 */
    private String reimbursementAmount;
    /** 物品类型 */
    private String reimbursementType;
    /** 报销物品附件 */
    private String reimbursementAttachment;
}
