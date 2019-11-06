package com.contestgo.contestgobackend.bean;

import lombok.Data;

@Data
public class University {

    /** 学校id */
    private Integer ID;

    /** 学校名 */
    private String name;

    /** 省份id */
    private Integer provinceID;

    /** 学校主页 */
    private String website;

    /** 学校所在城市 */
    private String city;

}
