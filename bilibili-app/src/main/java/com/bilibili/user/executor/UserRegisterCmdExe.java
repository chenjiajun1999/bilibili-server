package com.bilibili.user.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.user.assembler.UserAssembler;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRegisterCmdExe {


    @Resource
    private UserGateway userGateway;

    public Response execute(UserRegisterCmd cmd) {

        if (userGateway.checkByPhone(cmd.getPhone())) {
            throw new BizException(ErrorCode.B_USER_phoneExit.getErrCode(), ErrorCode.B_USER_phoneExit.getErrDesc());
        }
        userGateway.register(UserAssembler.toEntity(cmd));
        return Response.buildSuccess();
    }
}
