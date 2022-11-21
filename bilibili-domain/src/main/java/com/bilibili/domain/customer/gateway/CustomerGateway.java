package com.bilibili.domain.customer.gateway;

import com.bilibili.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
