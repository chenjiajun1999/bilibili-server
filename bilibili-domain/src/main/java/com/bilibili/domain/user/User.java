package com.bilibili.domain.user;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号
     */
    private UserPhone phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private UserPasswordEncoder encoder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
