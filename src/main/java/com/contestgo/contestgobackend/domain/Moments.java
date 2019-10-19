package com.contestgo.contestgobackend.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.*;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-10-19 11:34
 **/
@Data
@ApiModel(value = "动态", description = "动态分享")
public class Moments {
    /** id */
    private int moments_id;
    /** 发布者 */
    private String moments_publisher;
    /** 发布内容 */
    private String moments_content;
    /** 发布时间 */
    private Timestamp publish_time;
}
