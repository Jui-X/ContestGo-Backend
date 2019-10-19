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
    private int moments_id;
    /** 动态标题 */
    private String moments_title;
    /** 动态发布者 */
    private String moments_publisher;
}
