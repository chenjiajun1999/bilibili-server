package com.bilibili.domain.user;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;
import lombok.Data;

@Data
public class UserInfoNick {

    private String nick;

    public UserInfoNick(String nick) {

        if (StrUtil.isBlank(nick)) {
            throw new BizException(ErrorCode.B_USER_nickBlank.getErrCode(),
                    ErrorCode.B_USER_nickBlank.getErrDesc());
        }

        this.nick = nick;
    }

    public UserInfoNick() {

        this.nick = "bid_" + RandomUtil.randomString(8);

    }
}
