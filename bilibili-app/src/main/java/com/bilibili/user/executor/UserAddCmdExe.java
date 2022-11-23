package com.bilibili.user.executor;

import com.alibaba.cola.dto.Response;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.user.dto.UserAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserAddCmdExe {


    @Resource
    private UserGateway userGateway;

    public Response execute(UserAddCmd cmd){


        return Response.buildSuccess();
    }
}
