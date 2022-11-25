package com.bilibili.gatewayimpl.user.convertor;

import cn.hutool.core.date.DateUtil;
import com.bilibili.domain.user.User;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;

import java.time.LocalDateTime;

public class UserConvertor {

    public static UserDO createUserDO(User user) {

        UserDO userDO = new UserDO();
        userDO.setPhone(user.getPhone().getNumber());
        userDO.setPassword(user.getEncoder().getPassword());
        userDO.setSalt(user.getEncoder().getSalt());

        LocalDateTime now = LocalDateTime.now();
        userDO.setCreateTime(now);
        userDO.setUpdateTime(now);

        return userDO;

    }
}
