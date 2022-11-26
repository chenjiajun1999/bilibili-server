package com.bilibili.user.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoModifyCmd  extends Command {

    private String nick;
    private String avatar;
    private String sign;
    private String gender;
    private String birth;

}
