package com.bilibili.user.dto.data;

public enum ErrorCode {

    B_USER_NOT_EXIT("B_USER_NOT_EXIT", "用户不存在"),

    B_USER_PASSWORD_BLANK("B_USER_PASSWORD_BLANK", "密码为空"),
    B_USER_PASSWORD_RSA_FAILED("B_USER_PASSWORD_RSA_FAILED", "密码 RSA 解密失败"),
    B_USER_PASSWORD_ERROR("B_USER_PASSWORD_ERROR", "密码错误"),

    B_USER_PHONE_EXIT("B_USER_PHONE_EXIT", "手机号已存在"),
    B_USER_PHONE_NOT_EXIT("B_USER_PHONE_NOT_EXIT", "手机号不存在"),
    B_USER_PHONE_BLANK("B_USER_PHONE_BLANK", "手机号为空"),
    B_USER_PHONE_INVALID("B_USER_PHONE_INVALID", "手机号格式错误"),


    B_USER_EMAIL_EXIT("B_USER_EMAIL_EXIT", "邮箱已存在"),
    B_USER_EMAIL_INVALID("B_USER_EMAIL_INVALID", "邮箱格式错误"),

    B_USER_IDENTIFIER_BLANK("B_USER_IDENTIFIER_BLANK", "用户标识为空"),


    B_USER_NICK_BLANK("B_USER_NICK_BLANK", "用户名称为空"),
    B_USER_NICK_INVALID("B_USER_NICK_INVALID", "用户名称非法"),
    B_USER_NICK_EXIT("B_USER_NICK_EXIT", "用户名称已存在"),


    B_USER_INFO_NOT_EXIT("B_USER_INFO_NOT_EXIT", "用户信息不存在");


    private final String errCode;
    private final String errDesc;

    private ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }
}
