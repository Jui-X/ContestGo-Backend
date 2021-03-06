package com.contestgo.contestgobackend.bean;

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

    @ApiModelProperty(value = "用户名", name = "stuName", example = "juix", required = true)
    /** 用户名 */
    private String stuName;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    /** 用户密码 */
    private String password;

    @ApiModelProperty(value = "学校", name = "school", example = "ECNU")
    /** 用户学校 */
    private String university;

    @ApiModelProperty(value = "院系", name = "department", example = "scsse")
    /** 用户院系 */
    private String department;

    @ApiModelProperty(value = "学号", name = "stuId", example = "10165101101")
    /** 用户学号 */
    private String stuId;

    @ApiModelProperty(value = "手机号", name = "phoneNum", example = "18111011213")
    /** 用户手机号 */
    private String phoneNum;

    @ApiModelProperty(value = "邮箱", name = "emailAddress", example = "xxx@126.com")
    /** 用户邮箱 */
    private String emailAddress;

    @ApiModelProperty(value = "队伍ID", name = "team_id", example = "1")
    /** 用户队伍ID */
    private Integer teamId;

    @ApiModelProperty(value = "wxopenid", name = "openid", example = "xxx")
    /** 用户open_id */
    private String openId;
}
