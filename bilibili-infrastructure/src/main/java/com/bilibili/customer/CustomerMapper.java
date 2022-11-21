package com.bilibili.customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  CustomerDO getById(String customerId);
}
