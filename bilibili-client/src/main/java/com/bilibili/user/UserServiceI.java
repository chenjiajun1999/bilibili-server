package com.bilibili.user;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserRegisterCmd;

public interface UserServiceI {

    Response register(UserRegisterCmd userRegisterCmd);

    SingleResponse<String> login(UserLoginCmd userLoginCmd);

}
