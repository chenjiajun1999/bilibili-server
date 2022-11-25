package com.bilibili.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.bilibili.customer.dto.CustomerAddCmd;
import com.bilibili.customer.dto.CustomerListByNameQry;
import com.bilibili.customer.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
