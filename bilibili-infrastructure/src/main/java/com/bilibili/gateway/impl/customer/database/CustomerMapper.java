package com.bilibili.gateway.impl.customer.database;

import com.bilibili.gateway.impl.customer.database.object.CustomerDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  CustomerDO getById(String customerId);
}
