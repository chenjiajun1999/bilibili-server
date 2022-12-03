package com.bilibili.media.dto.data;

public enum ErrorCode {


    B_FILE_EMPTY("B_FILE_EMPTY","空文件"),
    B_FILE_UPLOAD_ERROR("B_FILE_UPLOAD_ERROR","文件上传错误去");


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
