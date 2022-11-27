package com.bilibili.user.assembler;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.domain.user.UserInfoNick;
import com.bilibili.user.dto.UserInfoModifyCmd;
import com.bilibili.user.dto.data.UserInfoDTO;
import org.springframework.beans.BeanUtils;

public class UserInfoAssembler {


    public static UserInfoDTO toDataTransferObject(UserInfo userInfo) {

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        BeanUtils.copyProperties(userInfo, userInfoDTO);

        userInfoDTO.setNick(userInfo.getUserInfoNick().getNick());
        userInfoDTO.setCreateTime(DateUtil.formatLocalDateTime(userInfo.getCreateTime()));
        userInfoDTO.setUpdateTime(DateUtil.formatLocalDateTime(userInfo.getUpdateTime()));
        return userInfoDTO;

    }


    public static UserInfo toEntity(UserInfoModifyCmd cmd) {

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(cmd, userInfo);

        if(StrUtil.isNotBlank(cmd.getNick())){
            userInfo.setUserInfoNick(new UserInfoNick(cmd.getNick()));
        }

        userInfo.setUserId(Convert.toLong(StpUtil.getLoginId()));
        return userInfo;
    }

}
