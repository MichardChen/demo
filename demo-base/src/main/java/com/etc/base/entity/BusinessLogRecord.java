package com.etc.base.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 记录业务日志实体类
 * @author ChenDang
 * @date 2019/5/28 0028
 */
@Data
@Document(collection = "log_business_record")
public class BusinessLogRecord extends BaseEntityMongo {

    /**
     * 请求模块
     */
    @Field("module")
    private String module;

    /**
     * 日志类型
     */
    @Field("log_type")
    private String logType;

    /**
     * 用户ID（sys_user的username）
     */
    @Field("user_id")
    private String userId;

    /**
     * 用户名称（sys_user的unit_name）
     */
    @Field("user_name")
    private String userName;

    /**
     * 类名
     */
    @Field("classname")
    private String className;

    /**
     * 方法名
     */
    @Field("method_name")
    private String methodName;

    /**
     * 用户IP
     */
    @Field("user_ip")
    private String userIp;

    /**
     * 请求url
     */
    @Field("url")
    private String url;

    /**
     * 操作系统名称
     */
    @Field("os_name")
    private String osName;

    /**
     * 浏览器名称
     */
    @Field("browser_name")
    private String browserName;

    /**
     * 登录请求执行状态 1-成功 0-失败
     */
    @Field("status")
    private String status;

    /**
     * 请求参数
     */
    @Field("param")
    private String param;

    /**
     * 开始时间
     */
    @Field("begin_time")
    private String beginTime;

    /**
     * 结束时间
     */
    @Field("end_time")
    private String endTime;

    /**
     * 错误消息
     */
    @Field("errmsg")
    private String errMsg;

    /**
     * 响应时间(毫秒)
     */
    @Field("resp_time")
    private String respTime;

    /**
     * 日志标题(模块)
     */
    @Field("title")
    private String title;

    /**
     * 操作人类别
     */
    @Field("operator_type")
    private String operatorType;

    /**
     * 用户操作地点
     */
    @Field("user_location")
    private String userLocation;

    /**
     * 终端
     */
    @Field("terminal")
    private String terminal;

}
