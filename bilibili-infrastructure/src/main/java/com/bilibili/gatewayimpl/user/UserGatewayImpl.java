package com.bilibili.gatewayimpl.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.UserInfo;
import com.bilibili.domain.user.gateway.UserGatewayI;
import com.bilibili.gatewayimpl.user.convertor.UserConvertor;
import com.bilibili.gatewayimpl.user.convertor.UserInfoConvertor;
import com.bilibili.gatewayimpl.user.database.UserInfoMapper;
import com.bilibili.gatewayimpl.user.database.UserMapper;
import com.bilibili.gatewayimpl.user.database.UserRoleMapper;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import com.bilibili.gatewayimpl.user.database.dataobject.UserInfoDO;
import com.bilibili.gatewayimpl.user.database.dataobject.UserRoleDO;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserGatewayImpl implements UserGatewayI {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public Boolean checkByPhone(String phone) {

        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return ObjectUtils.isNotEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public Boolean checkByEmail(String email) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        return ObjectUtils.isNotEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public Boolean checkById(Long id) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return ObjectUtils.isNotEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public Boolean checkByNick(String nick) {
        QueryWrapper<UserInfoDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick", nick);
        return ObjectUtils.isNotEmpty(userInfoMapper.selectOne(queryWrapper));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void register(User user) {

        UserDO userDO = UserConvertor.toDataObject(user);
        // 插入后获得自增 id
        userMapper.insert(userDO);
        userInfoMapper.insert(UserInfoConvertor.toDataObject(new UserInfo().init(userDO.getId())));

    }

    @Override
    public String login(User user) {

        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        // 手机号
        if (StrUtil.isNotBlank(user.getIdentifier().getPhone())) {
            queryWrapper.eq("phone", user.getIdentifier().getPhone());
        } else {
            queryWrapper.eq("email", user.getIdentifier().getEmail());
        }
        UserDO userDO = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userDO)) {
            throw new BizException(ErrorCode.B_USER_isNotExit.getErrCode(), ErrorCode.B_USER_isNotExit.getErrDesc());
        }
        // 验证
        user.getValidator().validate(userDO.getPassword(), userDO.getSalt());
        StpUtil.login(userDO.getId());
        return StpUtil.getTokenValue();

    }

    @Override
    public void modify(User user) {

        UpdateWrapper<UserDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("id", Convert.toLong(StpUtil.getLoginId()));
        userMapper.update(UserConvertor.toDataObject(user), updateWrapper);

    }

    @Override
    public void modify(UserInfo userInfo) {

        UpdateWrapper<UserInfoDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("userId", userInfo.getUserId());
        userInfoMapper.update(UserInfoConvertor.toDataObject(userInfo), updateWrapper);

    }

    @Override
    public UserInfo getUserInfoById(Long userId) {

        QueryWrapper<UserInfoDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);
        UserInfoDO userInfoDO = userInfoMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userInfoDO)) {
            throw new BizException(ErrorCode.B_USER_infoNotExit.getErrCode(), ErrorCode.B_USER_infoNotExit.getErrDesc());
        }

        return UserInfoConvertor.toEntity(userInfoDO);

    }

    @Override
    public UserInfo getUserInfoByNick(String nick) {
        QueryWrapper<UserInfoDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nick", nick);
        UserInfoDO userInfoDO = userInfoMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userInfoDO)) {
            throw new BizException(ErrorCode.B_USER_infoNotExit.getErrCode(), ErrorCode.B_USER_infoNotExit.getErrDesc());
        }
        return UserInfoConvertor.toEntity(userInfoDO);
    }

    @Override
    public Long getUserRoleIdById(Long userId) {

        QueryWrapper<UserRoleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        return userRoleMapper.selectOne(queryWrapper).getRoleId();

    }
}
