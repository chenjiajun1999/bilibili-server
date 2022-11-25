package com.bilibili.user.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.user.dto.UserModifyCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserModifyCmdExe {

    @Resource
    private UserGateway userGateway;

    public Response execute(UserModifyCmd cmd) {

        if (userGateway.checkById(cmd.getUserDTO().getId())) {
            throw new BizException(ErrorCode.B_USER_idNotExit.getErrCode(),ErrorCode.B_USER_idNotExit.getErrDesc());
        }

        User user = new User();
        BeanUtils.copyProperties(cmd.getUserDTO(),user);
        userGateway.save(user);
        return Response.buildSuccess();
    }

}
