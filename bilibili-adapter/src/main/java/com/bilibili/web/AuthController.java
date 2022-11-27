package com.bilibili.web;


import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.auth.AuthServiceI;
import com.bilibili.auth.dto.data.AuthDTO;
import com.bilibili.user.dto.data.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Auth Controller
 *
 * @author Jiajun Chen
 * @date 2022-11-27
 */
@RestController
public class AuthController {

    @Autowired
    AuthServiceI authService;

    @GetMapping("/auths")
    public SingleResponse<AuthDTO> getAuth(){
        return authService.getAuth();
    }



}
