package com.bilibili.gatewayimpl.auth.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bilibili.gatewayimpl.auth.database.dataobject.AuthElementOperationDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限控制--页面元素操作表 Mapper 接口
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Mapper
public interface AuthElementOperationMapper extends BaseMapper<AuthElementOperationDO> {

}
