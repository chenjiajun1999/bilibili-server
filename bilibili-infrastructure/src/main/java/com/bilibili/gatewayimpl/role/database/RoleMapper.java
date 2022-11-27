package com.bilibili.gatewayimpl.role.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bilibili.gatewayimpl.role.database.dataobject.RoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限控制--角色表 Mapper 接口
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {

}
