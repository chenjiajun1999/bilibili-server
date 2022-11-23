package com.bilibili.user.api;

import com.alibaba.cola.dto.Response;
import com.bilibili.user.dto.UserAddCmd;

public interface UserServiceI {

    Response addUser(UserAddCmd userAddCmd);

}
