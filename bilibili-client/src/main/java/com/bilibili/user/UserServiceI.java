package com.bilibili.user;

import com.alibaba.cola.dto.Response;
import com.bilibili.user.dto.UserRegisterCmd;

public interface UserServiceI {

    Response register(UserRegisterCmd userRegisterCmd);

}
