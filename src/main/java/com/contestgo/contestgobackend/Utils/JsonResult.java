package com.contestgo.contestgobackend.Utils;

/**
 * @param: none
 * @description: 自定义响应数据结构
 *				 这个类是提供给门户，ios，安卓，微信商城用的
 * 				 门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				 其他自行处理
 * 				 200：表示成功
 * 				 500：表示错误，错误信息在msg字段中
 * 				 501：bean验证错误，不管多少个错误都以map形式返回
 * 				 502：拦截器拦截到用户token出错
 * 				 555：异常抛出信息
 * @author: KingJ
 * @create: 2019-03-13 20:17
 **/
public class JsonResult<T> {

    /** 定义相应返回状态码 */
    private Integer status;

    /** 定义相应返回信息 */
    private String msg;

    /** 定义相应返回数据 */
    private Object data;

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult errorMsg(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult tokenErrorMsg(String msg) {
        return new JsonResult(502, msg, null);
    }

    public static JsonResult exceptionErrorMsg(String msg) {
        return new JsonResult(555, msg, null);
    }
}
