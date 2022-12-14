package com.bilibili.user.executor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.domain.user.gateway.UserGatewayI;
import com.bilibili.user.assembler.UserInfoAssembler;
import com.bilibili.user.dto.UserInfoModifyCmd;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserInfoModifyCmdExe {

    @Resource
    private UserGatewayI userGateway;

    public Response execute(UserInfoModifyCmd cmd) {

        UserInfo userInfo = UserInfoAssembler.toEntity(cmd);
        // 若修改 nick 检查是否重复
        if (StrUtil.isNotBlank(cmd.getNick()) && userGateway.checkByNick(cmd.getNick())) {
            throw new BizException(ErrorCode.B_USER_NICK_EXIT.getErrCode(), ErrorCode.B_USER_NICK_EXIT.getErrDesc());
        }
        userGateway.modify(userInfo.validate());
        return Response.buildSuccess();
    }
}
