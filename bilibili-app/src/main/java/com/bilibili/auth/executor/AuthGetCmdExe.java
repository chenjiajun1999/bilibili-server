package com.bilibili.auth.executor;


import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.auth.dto.data.AuthDTO;
import com.bilibili.domain.auth.gateway.AuthGatewayI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthGetCmdExe {

    @Autowired
    AuthGatewayI authGateway;

    public SingleResponse<AuthDTO> getAuth() {



        return null;

    }
}
