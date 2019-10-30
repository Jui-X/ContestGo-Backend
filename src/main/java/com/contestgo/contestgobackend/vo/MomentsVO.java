package com.contestgo.contestgobackend.vo;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 18:14
 **/
@Data
public class MomentsVO {
    private int momentsId;
    /** 动态标题 */
    private String momentsTitle;
    /** 动态发布者 */
    private String momentsPublisher;
}
