package com.bilibili.gatewayimpl.customer.database;

import com.bilibili.gatewayimpl.customer.database.dataobject.CustomerDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  CustomerDO getById(String customerId);
}
