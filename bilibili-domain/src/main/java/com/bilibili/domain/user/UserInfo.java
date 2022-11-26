package com.bilibili.domain.user;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserInfo implements UserConstant {

    private static final long serialVersionUID = 1L;

//    /**
//     * 主键
//     */
//    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 昵称
     */
    private UserNick userNick;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 签名
     */
    private String sign;

    /**
     * 性别：0男 1女 2未知
     */
    private String gender;

    /**
     * 生日
     */
    private String birth;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public UserInfo init(Long userId) {

        this.userId = userId;
        userNick = new UserNick();
        gender = GENDER_UNKNOW;
        birth = DEFAULT_BIRTH;
        return this;
    }

}
