package com.bilibili.user.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegisterCmd extends Command {

    private String phone;
    private String email;
    private String password;

}
