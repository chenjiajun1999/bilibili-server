package com.bilibili.user.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.domain.user.gateway.UserGatewayI;
import com.bilibili.user.assembler.UserInfoAssembler;
import com.bilibili.user.dto.data.UserInfoDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserInfoQueryByNickExe {

    @Resource
    private UserGatewayI userGateway;

    public SingleResponse<UserInfoDTO> execute(String nick) {

        UserInfo userInfo = userGateway.getUserInfoByNick(nick);
        return SingleResponse.of(UserInfoAssembler.toDataTransferObject(userInfo));
    }

}
