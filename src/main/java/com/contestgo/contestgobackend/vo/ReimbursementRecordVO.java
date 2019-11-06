package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-11-06 11:06
 **/
@Data
public class ReimbursementRecordVO {
    /** 报销物品 */
    private String reimbursementItem;
    /** 报销金额 */
    private String reimbursementAmount;
    /** 报销类型 */
    private Integer reimbursementType;
    /** 报销附件 */
    private String reimbursementAttachment;
}
