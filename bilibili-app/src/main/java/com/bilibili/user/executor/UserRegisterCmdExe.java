package com.bilibili.user.executor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGatewayI;
import com.bilibili.user.assembler.UserAssembler;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRegisterCmdExe {


    @Resource
    private UserGatewayI userGateway;

    public Response execute(UserRegisterCmd cmd) {

        User user = UserAssembler.toEntity(cmd);
        if (StrUtil.isNotBlank(cmd.getPhone()) && userGateway.checkByPhone(cmd.getPhone())) {
            throw new BizException(ErrorCode.B_USER_phoneExit.getErrCode(), ErrorCode.B_USER_phoneExit.getErrDesc());
        }
        if (StrUtil.isNotBlank(cmd.getEmail()) && userGateway.checkByEmail(cmd.getEmail())) {
            throw new BizException(ErrorCode.B_USER_emailExit.getErrCode(), ErrorCode.B_USER_emailExit.getErrDesc());
        }
        userGateway.register(user);
        return Response.buildSuccess();
    }
}
