package com.bilibili.user;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.user.dto.UserInfoModifyCmd;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.dto.data.UserInfoDTO;

public interface UserServiceI {

    Response register(UserRegisterCmd userRegisterCmd);

    SingleResponse<String> login(UserLoginCmd userLoginCmd);

    SingleResponse<UserInfoDTO> getUserInfo();

    SingleResponse<UserInfoDTO> getUserInfoByNick(String nick);

    Response modifyUserInfo(UserInfoModifyCmd cmd);



}
