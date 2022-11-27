package com.bilibili.domain.user.gateway;

import com.bilibili.domain.user.User;
import com.bilibili.domain.user.UserInfo;

public interface UserGatewayI {


    Boolean checkByPhone(String phone);

    Boolean checkByEmail(String email);

    Boolean checkById(Long id);

    Boolean checkByNick(String nick);

    void register(User user);

    void modify(User user);

    void modify(UserInfo userInfo);

    String login(User user);

    UserInfo getUserInfoById(Long userId);

    UserInfo getUserInfoByNick(String nick);

    Long getUserRoleIdById(Long userId);

}
