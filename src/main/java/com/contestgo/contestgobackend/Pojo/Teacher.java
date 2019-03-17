package com.contestgo.contestgobackend.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-03-17 10:24
 **/
@Data
@ApiModel(value = "教师对象", description = "教师对象信息")
public class Teacher {

    /** 教师id */
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "teacher_name", example = "juix", required = true)
    /** 用户名 */
    private String teacher_name;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    /** 用户密码 */
    private String password;

    @ApiModelProperty(value = "单位", name = "institution", example = "ECNU")
    /** 用户单位 */
    private String institution;

    @ApiModelProperty(value = "工号", name = "work_id", example = "10165101101")
    /** 用户工号 */
    private String work_id;

    @ApiModelProperty(value = "手机号", name = "phone_num", example = "18111011213")
    /** 用户手机号 */
    private String phone_num;

    @ApiModelProperty(value = "wxopenid", name = "openid", example = "xxx")
    /** 用户open_id */
    private String open_id;
}
