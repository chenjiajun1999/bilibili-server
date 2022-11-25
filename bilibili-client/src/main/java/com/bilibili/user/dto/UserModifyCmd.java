package com.bilibili.user.dto;


import com.alibaba.cola.dto.Command;
import com.bilibili.user.dto.data.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserModifyCmd extends Command {

    private UserDTO userDTO;

}
