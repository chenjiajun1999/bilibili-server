package com.bilibili.web;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.user.UserServiceI;
import com.bilibili.user.dto.UserInfoModifyCmd;
import com.bilibili.user.dto.UserLoginCmd;
import com.bilibili.user.dto.UserRegisterCmd;
import com.bilibili.user.dto.data.UserInfoDTO;
import com.bilibili.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        String pk = RSAUtil.getPublicKey();
        return SingleResponse.of(pk);
    }

    @PostMapping(value = "/users")
    public Response register(@RequestBody UserRegisterCmd cmd) {
        return userService.register(cmd);
    }

    @PostMapping(value = "/user-tokens")
    public SingleResponse<String> login(@RequestBody UserLoginCmd cmd) {
        return userService.login(cmd);
    }

    @GetMapping(value = "/user-infos")
    public SingleResponse<UserInfoDTO> getUserInfo() {
        return userService.getUserInfo();
    }

    @GetMapping(value = "/user-infos/{nick}")
    public SingleResponse<UserInfoDTO> getUserInfoByNick(@PathVariable String nick) {
        return userService.getUserInfoByNick(nick);
    }

    @PostMapping(value = "/user-infos")
    public Response modifyUserInfo(@RequestBody UserInfoModifyCmd cmd) {
        return userService.modifyUserInfo(cmd);
    }
}
