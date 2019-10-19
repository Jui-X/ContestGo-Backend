package com.contestgo.contestgobackend.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param: none
 * @description: 用户类
 * @author: KingJ
 * @create: 2019-03-06 19:28
 **/
@Data
@ApiModel(value = "用户对象", description = "用户对象信息")
public class Student {

    @ApiModelProperty(hidden = true)
    /** uid */
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "stu_name", example = "juix", required = true)
    /** 用户名 */
    private String stu_name;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    /** 用户密码 */
    private String password;

    @ApiModelProperty(value = "学校", name = "school", example = "ECNU")
    /** 用户学校 */
    private String unversity;

    @ApiModelProperty(value = "院系", name = "department", example = "scsse")
    /** 用户院系 */
    private String department;

    @ApiModelProperty(value = "学号", name = "stu_id", example = "10165101101")
    /** 用户学号 */
    private String stu_id;

    @ApiModelProperty(value = "手机号", name = "phone_num", example = "18111011213")
    /** 用户手机号 */
    private String phone_num;

    @ApiModelProperty(value = "wxopenid", name = "openid", example = "xxx")
    /** 用户open_id */
    private String open_id;
}
