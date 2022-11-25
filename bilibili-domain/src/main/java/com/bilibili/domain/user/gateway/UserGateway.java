package com.bilibili.domain.user.gateway;

import com.bilibili.domain.user.User;

public interface UserGateway {


    Boolean checkByPhone(String phone);

    Boolean checkById(Long id);


    void save(User user);

    void register(User user);

    void modify(User user);

}
