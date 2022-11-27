package com.bilibili.domain.auth;


import com.alibaba.cola.domain.Entity;
import lombok.Data;

@Data
@Entity
public class AuthRole {

    private String name;
    private String code;

}
