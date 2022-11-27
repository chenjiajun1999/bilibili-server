package com.bilibili.auth.dto.data;

import lombok.Data;

@Data
public class AuthElementOperationDTO {

    private String elementName;
    private String elementCode;
    private String operationType;
}
