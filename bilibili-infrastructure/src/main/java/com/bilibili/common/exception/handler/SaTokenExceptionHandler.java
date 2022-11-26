package com.bilibili.common.exception.handler;

import cn.dev33.satoken.exception.SaTokenException;
import com.alibaba.cola.dto.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaTokenExceptionHandler {

    @ExceptionHandler(SaTokenException.class)
    public Response handlerSaTokenException(SaTokenException e) {


        // 根据不同异常细分状态码返回不同的提示

        if (e.getCode() == 11011) {
            return Response.buildFailure("B_saTokenNotExit_11011", "未能读取到有效 Token");
        }
        else if (e.getCode() == 11012) {
            return Response.buildFailure("B_saTokenError_11012", "Token 无效");
        }
        else if (e.getCode() == 11013) {
            return Response.buildFailure("B_saTokenExpire_11013", "Token 已过期");
        }
        else if (e.getCode() == 11014) {
            return Response.buildFailure("B_saTokenError_11014", "Token 已被顶下线");
        }
        else if (e.getCode() == 11015) {
            return Response.buildFailure("B_saTokenError_11015", "Token 已被踢下线");
        }

        else if (e.getCode() == 20001) {
            return Response.buildFailure("B_saTokenError_20001", "redirect 重定向 url 是一个无效地址");
        }
        else if (e.getCode() == 20002) {
            return Response.buildFailure("B_saTokenError_20002", "redirect 重定向 url 不在 allowUrl 允许的范围内");
        }
        else if (e.getCode() == 20004) {
            return Response.buildFailure("B_saTokenError_20004", "提供的 ticket 是无效的");
        }
        // 更多 code 码判断 ...

        // 默认的提示
        return Response.buildFailure("B_saTokenError_500", "服务器繁忙，请稍后重试...");
    }
}
