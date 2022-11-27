package com.bilibili.user.assembler;


import com.bilibili.domain.user.Identifier;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.Validator;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserModifyCmd;
import com.bilibili.user.dto.UserRegisterCmd;

public class UserAssembler {


    public static User toEntity(UserRegisterCmd cmd) {
        User user = new User();
        user.setIdentifier(new Identifier(cmd.getPhone(), cmd.getEmail()));
        user.setValidator(new Validator().encoder(cmd.getPassword()));
        return user;
    }


    public static User toEntity(UserLoginCmd cmd) {
        User user = new User();
        user.setIdentifier(new Identifier(cmd.getPhone(), cmd.getEmail()));
        user.setValidator(new Validator().storage(cmd.getPassword()));
        return user;
    }

    public static User toEntity(UserModifyCmd cmd) {
        User user = new User();
        user.setIdentifier(new Identifier(cmd.getPhone(), cmd.getEmail()));
        user.setValidator(new Validator().storage(cmd.getPassword()));
        return user;
    }



}
