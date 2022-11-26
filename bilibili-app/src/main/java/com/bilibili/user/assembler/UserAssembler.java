package com.bilibili.user.assembler;


import com.bilibili.domain.user.UserPassword;
import com.bilibili.domain.user.UserPhone;
import com.bilibili.domain.user.User;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserRegisterCmd;

public class UserAssembler {


    public static User toEntity(UserRegisterCmd cmd) {
        User user = new User();
        user.setUserPhone(new UserPhone(cmd.getPhone()));
        user.setUserPassword(new UserPassword().encoder(cmd.getPassword()));
        return user;
    }


    public static User toEntity(UserLoginCmd cmd) {
        User user = new User();
        user.setUserPhone(new UserPhone(cmd.getPhone()));
        user.setUserPassword(new UserPassword().storage(cmd.getPassword()));
        return user;
    }

}
