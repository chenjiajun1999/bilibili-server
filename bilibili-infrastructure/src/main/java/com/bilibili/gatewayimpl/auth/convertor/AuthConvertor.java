package com.bilibili.gatewayimpl.auth.convertor;

import com.bilibili.domain.auth.AuthElementOperation;
import com.bilibili.domain.auth.AuthMenu;
import com.bilibili.gatewayimpl.auth.database.dataobject.AuthElementOperationDO;
import com.bilibili.gatewayimpl.auth.database.dataobject.AuthMenuDO;
import org.springframework.beans.BeanUtils;

public class AuthConvertor {

    public static AuthElementOperation toEntity(AuthElementOperationDO authElementOperationDO){

        AuthElementOperation authElementOperation = new AuthElementOperation();
        BeanUtils.copyProperties(authElementOperationDO,authElementOperation);
        return authElementOperation;

    }

    public static AuthMenu toEntity(AuthMenuDO authMenuDO){
        AuthMenu authMenu = new AuthMenu();
        BeanUtils.copyProperties(authMenuDO,authMenu);
        return authMenu;
    }

}
