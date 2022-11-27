package com.bilibili.gatewayimpl.user.convertor;

import com.bilibili.domain.user.User;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class UserConvertor {

    public static UserDO toDataObject(User user) {

        UserDO userDO = new UserDO();
        userDO.setPhone(user.getIdentifier().getPhone());
        userDO.setEmail(user.getIdentifier().getEmail());
        userDO.setPassword(user.getValidator().getPassword());
        userDO.setSalt(user.getValidator().getSalt());

        LocalDateTime now = LocalDateTime.now();
        userDO.setCreateTime(now);
        userDO.setUpdateTime(now);

        return userDO;

    }



}
