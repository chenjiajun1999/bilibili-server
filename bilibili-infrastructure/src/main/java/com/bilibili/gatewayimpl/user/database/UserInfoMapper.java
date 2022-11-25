package com.bilibili.gatewayimpl.user.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDO> {

}
