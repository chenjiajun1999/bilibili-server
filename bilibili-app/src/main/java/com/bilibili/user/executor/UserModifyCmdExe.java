package com.bilibili.user.executor;

import com.alibaba.cola.dto.Response;
import com.bilibili.domain.user.gateway.UserGatewayI;
import com.bilibili.user.dto.UserModifyCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserModifyCmdExe {

    @Resource
    private UserGatewayI userGateway;

    public Response execute(UserModifyCmd cmd) {


        return Response.buildSuccess();
    }

}
