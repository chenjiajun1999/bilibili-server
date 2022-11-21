package com.bilibili.domain.customer.gateway;

import com.bilibili.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
