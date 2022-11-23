package com.bilibili.user;


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.bilibili.user.api.UserServiceI;
import com.bilibili.user.dto.UserAddCmd;
import com.bilibili.user.executor.UserAddCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class UserServiceImpl implements UserServiceI {

    @Resource
    UserAddCmdExe userAddCmdExe;


    @Override
    public Response addUser(UserAddCmd userAddCmd) {
        return userAddCmdExe.execute(userAddCmd);
    }
}
