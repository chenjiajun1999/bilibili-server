package com.bilibili.auth.assembler;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.auth.dto.data.AuthMenuDTO;
import com.bilibili.domain.auth.AuthMenu;
import org.springframework.beans.BeanUtils;

public class AuthMenuAssembler {

    public static AuthMenuDTO toDataTransformObject(AuthMenu authMenu){

        if(ObjectUtils.isEmpty(authMenu)){
            return null;
        }

        AuthMenuDTO authMenuDTO = new AuthMenuDTO();
        BeanUtils.copyProperties(authMenu,authMenuDTO);
        return authMenuDTO;
    }
}
