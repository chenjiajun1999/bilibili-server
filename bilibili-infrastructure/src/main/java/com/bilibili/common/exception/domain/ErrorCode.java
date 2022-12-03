package com.bilibili.common.exception.domain;

public enum ErrorCode {

    B_TOKEN_ERROR("B_TOKEN_ERROR","未能读取到有效 Token"),
    B_TOKEN_NOT_EXIT("B_TOKEN_NOT_EXIT","用户未登录"),
    B_TOKEN_INVALID("B_TOKEN_INVALID","无效 Token"),
    B_TOKEN_EXPIRE("B_TOKEN_EXPIRE","用户已过期"),
    B_TOKEN_IS_REPLACED("B_TOKEN_IS_REPLACED","用户已被顶下线"),
    B_TOKEN_IS_BANNED("B_TOKEN_IS_BANNED","用户已被踢下线"),
    B_TOKEN_PERMISSION_DENIED("B_TOKEN_PERMISSION_DENIED","权限不足"),
    B_TOKEN_UNKNOW_ERROR("B_TOKEN_UNKNOW_ERROR","服务器繁忙，请稍后重试...");


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
