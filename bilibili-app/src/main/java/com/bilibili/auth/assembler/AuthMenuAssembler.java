package com.bilibili.auth.assembler;

import com.bilibili.auth.dto.data.AuthMenuDTO;
import com.bilibili.domain.auth.AuthMenu;
import org.springframework.beans.BeanUtils;

public class AuthMenuAssembler {

    public static AuthMenuDTO toDataTransformObject(AuthMenu authMenu){

        AuthMenuDTO authMenuDTO = new AuthMenuDTO();
        BeanUtils.copyProperties(authMenuDTO,authMenu);
        return authMenuDTO;
    }
}
