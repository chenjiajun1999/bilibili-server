package com.bilibili.auth.assembler;

import com.bilibili.auth.dto.data.AuthDTO;
import com.bilibili.auth.dto.data.AuthElementOperationDTO;
import com.bilibili.auth.dto.data.AuthMenuDTO;
import com.bilibili.domain.auth.AuthElementOperation;
import com.bilibili.domain.auth.AuthMenu;

import java.util.ArrayList;
import java.util.List;

public class AuthAssembler {


    public static AuthDTO toDataTransformObject(List<AuthElementOperation> authElementOperationList, List<AuthMenu> authMenuList) {

        List<AuthElementOperationDTO> authElementOperationDTOList = new ArrayList<>();
        List<AuthMenuDTO> authMenuDTOList = new ArrayList<>();

        authElementOperationList.forEach(e ->
                authElementOperationDTOList.add(AuthElementOperationAssembler.toDataTransformObject(e)));
        authMenuList.forEach(e ->
                authMenuDTOList.add(AuthMenuAssembler.toDataTransformObject(e)));

        return new AuthDTO(authElementOperationDTOList, authMenuDTOList);
    }

}
