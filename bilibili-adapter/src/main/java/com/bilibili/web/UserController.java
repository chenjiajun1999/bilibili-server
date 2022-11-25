package com.bilibili.web;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.user.UserServiceI;
import com.bilibili.user.dto.UserRegisterCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @author Jiajun Chen
 * @date 2022-11-22
 */
@RestController
public class UserController {


    @Autowired
    UserServiceI userService;


    @GetMapping("/rsa-pks")
    public SingleResponse<String> getRsaPublicKey() {
        String pk = SecureUtil.rsa().getPublicKeyBase64();
        return SingleResponse.of(pk);
    }

    @PostMapping(value = "/users")
    public Response register(@RequestBody UserRegisterCmd cmd) {
        return userService.register(cmd);
    }

    @PostMapping(value = "/user-tokens")
    public SingleResponse<String> login() {
        return null;
    }
}
