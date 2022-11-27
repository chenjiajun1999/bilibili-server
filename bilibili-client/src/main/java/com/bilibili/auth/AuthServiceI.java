package com.bilibili.auth;

import com.alibaba.cola.dto.SingleResponse;
import com.bilibili.auth.dto.data.AuthDTO;

public interface AuthServiceI {
    SingleResponse<AuthDTO> getAuth();
}

