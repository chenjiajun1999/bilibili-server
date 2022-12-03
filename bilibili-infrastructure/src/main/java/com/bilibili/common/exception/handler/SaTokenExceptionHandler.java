package com.bilibili.common.exception.handler;

import cn.dev33.satoken.exception.SaTokenException;
import com.alibaba.cola.dto.Response;
import com.bilibili.common.exception.domain.ErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaTokenExceptionHandler {

    @ExceptionHandler(SaTokenException.class)
    public Response handlerSaTokenException(SaTokenException e) {

        // 根据不同异常细分状态码返回不同的提示
        if (e.getCode() == 11001) {
            return Response.buildFailure(ErrorCode.B_TOKEN_ERROR.getErrCode(),
                    ErrorCode.B_TOKEN_ERROR.getErrDesc());
        } else if (e.getCode() == 11011) {
            return Response.buildFailure(ErrorCode.B_TOKEN_NOT_EXIT.getErrCode(),
                    ErrorCode.B_TOKEN_NOT_EXIT.getErrDesc());
        } else if (e.getCode() == 11012) {
            return Response.buildFailure(ErrorCode.B_TOKEN_INVALID.getErrCode(),
                    ErrorCode.B_TOKEN_INVALID.getErrDesc());
        } else if (e.getCode() == 11013) {
            return Response.buildFailure(ErrorCode.B_TOKEN_EXPIRE.getErrCode(),
                    ErrorCode.B_TOKEN_EXPIRE.getErrDesc());
        } else if (e.getCode() == 11014) {
            return Response.buildFailure(ErrorCode.B_TOKEN_IS_REPLACED.getErrCode(),
                    ErrorCode.B_TOKEN_IS_REPLACED.getErrDesc());
        } else if (e.getCode() == 11015) {
            return Response.buildFailure(ErrorCode.B_TOKEN_IS_BANNED.getErrCode(),
                    ErrorCode.B_TOKEN_IS_BANNED.getErrDesc());
        } else if (e.getCode() == 11041 || e.getCode() == 11051) {
            return Response.buildFailure(ErrorCode.B_TOKEN_PERMISSION_DENIED.getErrCode(),
                    ErrorCode.B_TOKEN_PERMISSION_DENIED.getErrDesc());
        }
        // 更多 code 码判断 ...

        // 默认的提示
        return Response.buildFailure(ErrorCode.B_TOKEN_UNKNOW_ERROR.getErrCode(),
                ErrorCode.B_TOKEN_UNKNOW_ERROR.getErrDesc());
    }
}
