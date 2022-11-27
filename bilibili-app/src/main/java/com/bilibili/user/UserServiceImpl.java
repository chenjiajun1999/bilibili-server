package com.bilibili.user;


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.user.dto.UserInfoModifyCmd;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserModifyCmd;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.dto.data.UserInfoDTO;
import com.bilibili.user.executor.UserInfoModifyCmdExe;
import com.bilibili.user.executor.UserLoginCmdExe;
import com.bilibili.user.executor.UserModifyCmdExe;
import com.bilibili.user.executor.UserRegisterCmdExe;
import com.bilibili.user.executor.query.UserInfoQueryByNickExe;
import com.bilibili.user.executor.query.UserInfoQueryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class UserServiceImpl implements UserServiceI {

    @Resource
    UserRegisterCmdExe userRegisterCmdExe;

    @Resource
    UserLoginCmdExe userLoginCmdExe;

    @Resource
    UserInfoQueryExe userInfoQueryExe;

    @Resource
    UserInfoQueryByNickExe userInfoQueryByNickExe;

    @Resource
    UserInfoModifyCmdExe userInfoModifyCmdExe;

    @Resource
    UserModifyCmdExe userModifyCmdExe;


    @Override
    public Response register(UserRegisterCmd userRegisterCmd) {
        return userRegisterCmdExe.execute(userRegisterCmd);
    }

    @Override
    public SingleResponse<String> login(UserLoginCmd userLoginCmd) {
        return userLoginCmdExe.execute(userLoginCmd);
    }

    @Override
    public Response modify(UserModifyCmd userModifyCmd) {
        return userModifyCmdExe.execute(userModifyCmd);
    }

    @Override
    public SingleResponse<UserInfoDTO> getUserInfo() {
        return userInfoQueryExe.execute();
    }

    @Override
    public SingleResponse<UserInfoDTO> getUserInfoByNick(String nick) {
        return userInfoQueryByNickExe.execute(nick);
    }

    @Override
    public Response modifyUserInfo(UserInfoModifyCmd cmd) {
        return userInfoModifyCmdExe.execute(cmd);
    }
}
