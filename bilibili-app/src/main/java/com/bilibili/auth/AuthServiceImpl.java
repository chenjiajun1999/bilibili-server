package com.bilibili.auth;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.auth.dto.data.AuthDTO;
import com.bilibili.auth.executor.AuthGetCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class AuthServiceImpl implements AuthServiceI{

    @Resource
    AuthGetCmdExe authGetCmdExe;

    @Override
    public SingleResponse<AuthDTO> getAuth() {
        return authGetCmdExe.getAuth();
    }
}
