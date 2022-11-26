package com.bilibili.domain.user;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;


public class UserPhone {

    private final String phone;

    public UserPhone(String phone) {

        if (StrUtil.isBlank(phone)) {
            throw new BizException(ErrorCode.B_USER_phoneBlank.getErrCode(),
                    ErrorCode.B_USER_phoneBlank.getErrDesc());
        }

        if (!Validator.isMobile(phone)) {
            throw new BizException(ErrorCode.B_USER_phoneInvalid.getErrCode(),
                    ErrorCode.B_USER_phoneInvalid.getErrDesc());
        }

        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}
