package com.bilibili.gateway.impl.user.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bilibili.gateway.impl.user.database.object.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
