package com.bilibili.gatewayimpl.user.convertor;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class UserInfoConvertor {

    public static UserInfo toEntity(UserInfoDO userInfoDO) {

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDO, userInfo);
        return userInfo;
    }

    public static UserInfoDO toDataObject(UserInfo userInfo) {

        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userInfo, userInfoDO);
        userInfoDO.setUpdateTime(LocalDateTime.now());
        return userInfoDO;
    }
}
