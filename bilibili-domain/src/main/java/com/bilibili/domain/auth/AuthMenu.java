package com.bilibili.domain.auth;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

@Data
@Entity
public class AuthMenu {

    private String name;
    private String code;

}
