package com.bilibili.gatewayimpl.role;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bilibili.domain.role.gateway.RoleGatewayI;
import com.bilibili.gatewayimpl.role.database.RoleAuthElementOperationMapper;
import com.bilibili.gatewayimpl.role.database.RoleAuthMenuMapper;
import com.bilibili.gatewayimpl.role.database.RoleMapper;
import com.bilibili.gatewayimpl.role.database.dataobject.RoleAuthElementOperationDO;
import com.bilibili.gatewayimpl.role.database.dataobject.RoleAuthMenuDO;
import com.bilibili.gatewayimpl.role.database.dataobject.RoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleGatewayImpl implements RoleGatewayI {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleAuthMenuMapper roleAuthMenuMapper;

    @Autowired
    RoleAuthElementOperationMapper roleAuthElementOperationMapper;


    @Override
    public List<Long> getAuthMenuIdByRoleId(Long roleId) {

        QueryWrapper<RoleAuthMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId", roleId);
        return roleAuthMenuMapper.selectList(queryWrapper)
                .stream().map(RoleAuthMenuDO::getMenuId).collect(Collectors.toList());
    }

    @Override
    public String getRoleNameById(Long id) {
        QueryWrapper<RoleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return roleMapper.selectOne(queryWrapper).getName();
    }

    @Override
    public String getRoleCodeById(Long id) {
        QueryWrapper<RoleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return roleMapper.selectOne(queryWrapper).getCode();
    }

    @Override
    public List<Long> getAuthElementOperationIdByRoleId(Long roleId) {

        QueryWrapper<RoleAuthElementOperationDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId", roleId);
        return roleAuthElementOperationMapper.selectList(queryWrapper)
                .stream().map(RoleAuthElementOperationDO::getElementOperationId).collect(Collectors.toList());
    }
}
