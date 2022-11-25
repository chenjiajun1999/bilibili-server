package com.bilibili.user.dto.data;

public enum ErrorCode {

    B_USER_idNotExit("B_USER_idNotExit", "用户不存在"),

    B_USER_passwordBlank("B_USER_passwordBlank", "密码为空"),
    B_USER_passwordRSAFailed("B_USER_passwordRSAFailed", "密码 RSA 解密失败"),
    B_USER_passwordError("B_USER_passwordError", "密码错误"),

    B_USER_phoneExit("B_USER_phoneExit", "手机号已存在"),
    B_USER_phoneInvalid("B_USER_phoneInvalid", "手机号格式错误"),
    B_USER_phoneBlank("B_USER_phoneBlank", "手机号为空");


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
