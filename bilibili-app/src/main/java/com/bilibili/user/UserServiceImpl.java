package com.bilibili.user;


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.executor.UserRegisterCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class UserServiceImpl implements UserServiceI {

    @Resource
    UserRegisterCmdExe userRegisterCmdExe;


    @Override
    public Response register(UserRegisterCmd userRegisterCmd) {
        return userRegisterCmdExe.execute(userRegisterCmd);
    }
}
