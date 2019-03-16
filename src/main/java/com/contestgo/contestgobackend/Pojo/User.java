package com.contestgo.contestgobackend.Pojo;

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
@ApiModel(value = "用户对象", description = "这是用户对象")
public class User {

    @ApiModelProperty(hidden = true)
    /** uid */
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "username", example = "juix", required = true)
    /** 用户名 */
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    /** 用户密码 */
    private String password;

    /** 用户学校 */
    private String unversity;

    /** 用户院系 */
    private String department;

    /** 用户学号 */
    private String stu_num;

    /**  */
    private String work_num;

    /** 用户手机号 */
    private String phone_num;

    /** 用户open_id */
    private String open_id;
}
