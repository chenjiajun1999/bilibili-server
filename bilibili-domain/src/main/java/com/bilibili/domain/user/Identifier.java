package com.bilibili.domain.user;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;
import lombok.Getter;

@Getter
public class Identifier {

    private final String phone;
    private final String email;

    public Identifier(String phone, String email) {

        // 用户至少要有一个手机和邮箱
        if (StrUtil.isBlank(phone) && StrUtil.isBlank(email)) {
            throw new BizException(ErrorCode.B_USER_identifierBlank.getErrCode(),
                    ErrorCode.B_USER_identifierBlank.getErrDesc());
        }

        // 验证手机
        if (phone != null && !Validator.isMobile(phone)) {
            throw new BizException(ErrorCode.B_USER_phoneInvalid.getErrCode(),
                    ErrorCode.B_USER_phoneInvalid.getErrDesc());

        }

        // 验证邮箱
        if (email != null && !Validator.isEmail(email)) {
            throw new BizException(ErrorCode.B_USER_emailInvalid.getErrCode(),
                    ErrorCode.B_USER_emailInvalid.getErrDesc());
        }

        this.phone = phone;
        this.email = email;
    }

}
