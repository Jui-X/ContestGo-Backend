package com.contestgo.contestgobackend.vo;

import java.sql.Timestamp;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-21 14:04
 **/
public class MomentsContentVO {

    private int momentsId;
    /** 动态标题 */
    private String momentsTitle;
    /** 动态发布者 */
    private String momentsPublisher;
    /** 动态详情 */
    private String momentsContent;
    /** 发布时间 */
    private Timestamp publishTime;

}
