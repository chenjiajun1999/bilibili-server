package com.bilibili.domain.user;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.domain.Entity;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class UserInfo {

    private static final long serialVersionUID = 1L;
    public static final String DEFAULT_BIRTH = "1999-10-01";
    public static final String GENDER_MALE = "0";
    public static final String GENDER_FEMALE = "1";
    public static final String GENDER_UNKNOW = "2";


    private Long userId;
    private String nick;
    private String avatar;
    private String sign;
    private String gender;
    private String birth;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public UserInfo init(Long userId) {

        this.userId = userId;
        nick = "bid_" + RandomUtil.randomString(8);
        gender = GENDER_UNKNOW;
        birth = DEFAULT_BIRTH;
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
        return this;
    }

    /**
     * 检测信息有效性和合法性
     */
    public UserInfo validate(){

        // null 通过，update 无影响
        if (nick != null && StrUtil.isBlank(nick)) {
            throw new BizException(ErrorCode.B_USER_nickBlank.getErrCode(),
                    ErrorCode.B_USER_nickBlank.getErrDesc());
        }
        // 敏感词过滤 ...

        return this;

    }

}
