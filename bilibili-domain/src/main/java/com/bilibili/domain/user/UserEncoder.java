package com.bilibili.domain.user;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;
import com.bilibili.utils.RSAUtils;
import lombok.Data;


@Data
public class UserEncoder {

    private String password;

    private String salt;


    // 注册调用
    public UserEncoder(String password) {

        if (StrUtil.isBlank(password)) {
            throw new BizException(ErrorCode.B_USER_passwordBlank.getErrCode(),
                    ErrorCode.B_USER_passwordBlank.getErrDesc());
        }

        try {
            RSAUtils.decrypt(password);
        } catch (Exception e) {
            throw new BizException(ErrorCode.B_USER_passwordRSAFailed.getErrCode(),
                    ErrorCode.B_USER_passwordRSAFailed.getErrDesc());
        }

        this.salt = RandomUtil.randomString(8);
        this.password = SecureUtil.md5(password + salt);

    }

    // 登录调用
    public UserEncoder(String password, String encryptPassword, String salt) {

        if (StrUtil.isBlank(password)) {
            throw new BizException(ErrorCode.B_USER_passwordBlank.getErrCode(),
                    ErrorCode.B_USER_passwordBlank.getErrDesc());
        }

        try {
            RSAUtils.decrypt(password);
        } catch (Exception e) {
            throw new BizException(ErrorCode.B_USER_passwordRSAFailed.getErrCode(),
                    ErrorCode.B_USER_passwordRSAFailed.getErrDesc());
        }

        this.password = encryptPassword;
        this.salt = salt;

        if (encryptPassword.equals(SecureUtil.md5(password + salt))) {

            throw new BizException(ErrorCode.B_USER_passwordError.getErrCode(),
                    ErrorCode.B_USER_passwordError.getErrDesc());

        }

    }

}
