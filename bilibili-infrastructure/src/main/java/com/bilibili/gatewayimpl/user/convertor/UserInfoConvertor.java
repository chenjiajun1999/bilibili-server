package com.bilibili.gatewayimpl.user.convertor;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.domain.user.UserNick;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class UserInfoConvertor {

    // 用于查询
    public static UserInfo toEntity(UserInfoDO userInfoDO) {

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDO, userInfo);
        userInfo.setUserNick(new UserNick(userInfoDO.getNick()));
        return userInfo;
    }


    // 用于注册
    public static UserInfoDO toDataObject(UserDO userDO) {

        UserInfoDO userInfoDO = new UserInfoDO();
        UserInfo userInfo = new UserInfo().init(userDO.getId());
        BeanUtils.copyProperties(userInfo, userInfoDO);
        userInfoDO.setNick(userInfo.getUserNick().getNick());
        return userInfoDO;
    }

    // 用于更新
    public static UserInfoDO toDataObject(UserInfo userInfo) {

        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userInfo, userInfoDO);

        if (ObjectUtils.isNotEmpty(userInfo.getUserNick())) {
            userInfoDO.setNick(userInfo.getUserNick().getNick());
        }

        userInfoDO.setUpdateTime(LocalDateTime.now());
        return userInfoDO;
    }
}
