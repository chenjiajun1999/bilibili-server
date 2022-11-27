package com.bilibili.domain.auth;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

@Data
@Entity
public class AuthElementOperation {

    public static final String OPERATION_CLICKABLE = "0";
    public static final String OPERATION_ViSABLE = "1";

    private String elementName;
    private String elementCode;
    private String operationType;

}
