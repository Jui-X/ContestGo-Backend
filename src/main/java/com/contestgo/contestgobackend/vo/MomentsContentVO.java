package com.contestgo.contestgobackend.vo;

import java.sql.Timestamp;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-21 14:04
 **/
public class MomentsContentVO {

    private int moments_id;
    /** 动态标题 */
    private String moments_title;
    /** 动态发布者 */
    private String moments_publisher;
    /** 动态详情 */
    private String moments_content;
    /** 发布时间 */
    private Timestamp publish_time;

}
