package com.bilibili.auth.assembler;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.auth.dto.data.AuthElementOperationDTO;
import com.bilibili.domain.auth.AuthElementOperation;
import org.springframework.beans.BeanUtils;

public class AuthElementOperationAssembler {

    public static AuthElementOperationDTO toDataTransformObject(AuthElementOperation authElementOperation){

        if(ObjectUtils.isEmpty(authElementOperation)){
            return null;
        }

        AuthElementOperationDTO authElementOperationDTO = new AuthElementOperationDTO();
        BeanUtils.copyProperties(authElementOperation,authElementOperationDTO);
        return authElementOperationDTO;

    }
}
