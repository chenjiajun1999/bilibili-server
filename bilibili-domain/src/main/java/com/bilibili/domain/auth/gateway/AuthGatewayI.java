package com.bilibili.domain.auth.gateway;

import com.bilibili.domain.auth.AuthElementOperation;
import com.bilibili.domain.auth.AuthMenu;

import java.util.List;

public interface AuthGatewayI {

    public AuthElementOperation getAuthElementOperationById(Long elementOperationId);

    public AuthMenu getAuthMenuById(Long menuId);

}
