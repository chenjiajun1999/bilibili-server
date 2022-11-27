package com.bilibili.auth.assembler;

import com.bilibili.auth.dto.data.AuthElementOperationDTO;
import com.bilibili.domain.auth.AuthElementOperation;
import org.springframework.beans.BeanUtils;

public class AuthElementOperationAssembler {

    public static AuthElementOperationDTO toDataTransformObject(AuthElementOperation authElementOperation){

        AuthElementOperationDTO authElementOperationDTO = new AuthElementOperationDTO();
        BeanUtils.copyProperties(authElementOperationDTO,authElementOperation);
        return authElementOperationDTO;

    }
}
