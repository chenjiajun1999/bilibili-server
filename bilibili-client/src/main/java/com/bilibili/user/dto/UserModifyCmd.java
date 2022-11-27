package com.bilibili.user.dto;


import com.alibaba.cola.dto.Command;
import com.bilibili.user.dto.data.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserModifyCmd extends Command {

    private String phone;
    private String email;
    private String password;
    private String newPassword;

}
