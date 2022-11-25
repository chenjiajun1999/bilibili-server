package com.bilibili.user.assembler;


import com.bilibili.domain.user.UserEncoder;
import com.bilibili.domain.user.UserPhone;
import com.bilibili.domain.user.User;
import com.bilibili.user.dto.UserRegisterCmd;

public class UserAssembler {


    public static User toEntity(UserRegisterCmd cmd) {
        User user = new User();
        user.setPhone(new UserPhone(cmd.getPhone()));
        user.setEncoder(new UserEncoder(cmd.getPassword()));
        return user;
    }

}
