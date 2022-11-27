package com.bilibili.gatewayimpl.user.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bilibili.gatewayimpl.user.database.dataobject.UserFollowingDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注表 Mapper 接口
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Mapper
public interface UserFollowingMapper extends BaseMapper<UserFollowingDO> {

}
