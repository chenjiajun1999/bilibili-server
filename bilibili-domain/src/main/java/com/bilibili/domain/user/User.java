package com.bilibili.domain.user;


import com.alibaba.cola.domain.Entity;
import lombok.Data;

@Data
@Entity
public class User {

    private static final long serialVersionUID = 1L;
    private Identifier identifier;
    private Validator validator;

}
