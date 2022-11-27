package com.bilibili.gatewayimpl.role.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bilibili.gatewayimpl.role.database.dataobject.RoleAuthElementOperationDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限控制--角色与元素操作关联表 Mapper 接口
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Mapper
public interface RoleAuthElementOperationMapper extends BaseMapper<RoleAuthElementOperationDO> {

}
