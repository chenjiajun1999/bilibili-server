package com.bilibili.user.executor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.user.assembler.UserAssembler;
import com.bilibili.user.dto.UserModifyCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserModifyCmdExe {

    @Resource
    private UserGateway userGateway;

    public Response execute(UserModifyCmd cmd) {


        return Response.buildSuccess();
    }

}
