package com.bilibili.user.assembler;


import com.bilibili.domain.user.UserPasswordEncoder;
import com.bilibili.domain.user.UserPhone;
import com.bilibili.domain.user.User;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserRegisterCmd;

public class UserAssembler {


    public static User toEntity(UserRegisterCmd cmd) {
        User user = new User();
        user.setPhone(new UserPhone(cmd.getPhone()));
        user.setEncoder(new UserPasswordEncoder().encoder(cmd.getPassword()));
        return user;
    }


    public static User toEntity(UserLoginCmd cmd) {
        User user = new User();
        user.setPhone(new UserPhone(cmd.getPhone()));
        user.setEncoder(new UserPasswordEncoder().storage(cmd.getPassword()));
        return user;
    }

}
