package com.bilibili.auth.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthDTO {


    List<AuthElementOperationDTO> authElementOperationList;
    List<AuthMenuDTO> authMenuList;


}
