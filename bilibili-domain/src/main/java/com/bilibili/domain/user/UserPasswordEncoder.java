package com.bilibili.domain.user;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.cola.exception.BizException;
import com.bilibili.user.dto.data.ErrorCode;
import com.bilibili.utils.RSAUtils;
import lombok.Data;


@Data
public class UserPasswordEncoder {

    private String password;

    private String salt;


    // 注册调用
    public UserPasswordEncoder encoder(String password) {

        check(password);

        this.salt = RandomUtil.randomString(8);
        this.password = SecureUtil.md5(password + salt);
        return this;
    }

    // 登录调用
    public UserPasswordEncoder storage(String password){

        check(password);

        this.password = password;
        return this;
    }


    public void verify(String encryptPassword, String salt) {

        if (!encryptPassword.equals(SecureUtil.md5(password + salt))) {

            throw new BizException(ErrorCode.B_USER_passwordError.getErrCode(),
                    ErrorCode.B_USER_passwordError.getErrDesc());

        }
    }

    public void check(String password){

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

    }
}
