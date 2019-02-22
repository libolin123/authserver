package com.maimeng.authserver.global.bean;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
public enum ResultCode {
    //成功
    SUCCESS(200),
    //失败
    FAIL(400),
    //未认证（签名错误）
    UNAUTHORIZED(401),
    //没有登录
    NO_LOGIN(402),
    //没有权限
    NO_PERMISSION(403),
    //接口不存在
    NOT_FOUND(404),
    //EC系统出现异常
    EC_ERROR(405),
    //用户状态异常、公司状态异常、产品状态异常
    STATE_ERROR(406),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500),

    //密码错误
    USER_NO_EXIST(10001),
    PASSWORD_ERROR(10002),
    //账号错误
    ACCOUNT_ERROR(20001),
    //登录失败
    LOGIN_FAIL_ERROR(20002),

    //超出推送最大限制
    PUSH_COUNT_TO_LARGE(30001),

    //超出推送最大限制
    PUSH_COUNT_BEYOND_TODAY_LIMIT(30002);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
