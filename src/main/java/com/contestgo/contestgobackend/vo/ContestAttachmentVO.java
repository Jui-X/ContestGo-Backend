package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 19:18
 **/
@Data
public class ContestAttachmentVO {
    /** 比赛名称 */
    private String contest_name;
    /** 比赛附件 */
    private String contest_attachment;
}
