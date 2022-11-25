package com.bilibili.user.executor;


import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.user.assembler.UserAssembler;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserLoginCmdExe {

    @Resource
    private UserGateway userGateway;

    public SingleResponse<String> execute(UserLoginCmd cmd) {

        User user = UserAssembler.toEntity(cmd);
        return SingleResponse.of(userGateway.login(user));
    }
}
