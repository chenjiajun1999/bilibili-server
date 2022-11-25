package com.bilibili.gatewayimpl.user.convertor;

import cn.hutool.core.date.DateUtil;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;

import java.time.LocalDateTime;

public class UserConvertor {

    public static UserDO toDataObject(User user) {

        UserDO userDO = new UserDO();
        userDO.setPhone(user.getPhone().getNumber());
        userDO.setPassword(user.getEncoder().getPassword());
        userDO.setSalt(user.getEncoder().getSalt());

        LocalDateTime now = LocalDateTime.now();
        userDO.setCreateTime(now);
        userDO.setUpdateTime(now);

        return userDO;

    }

    public static UserInfoDO toDataObject(UserDO userDO) {

        UserInfoDO userInfoDO = new UserInfoDO();
        UserInfo userInfo = new UserInfo(userDO.getId());

        userInfoDO.setUserId(userInfo.getUserId());
        userInfoDO.setGender(userInfo.getGender());
        userInfoDO.setBirth(userInfo.getBirth());
        userInfoDO.setAvatar(userInfo.getAvatar());
        userInfoDO.setNick(userInfo.getNick());

        userInfoDO.setCreateTime(userDO.getCreateTime());
        userInfoDO.setUpdateTime(userDO.getUpdateTime());

        return userInfoDO;

    }

}
