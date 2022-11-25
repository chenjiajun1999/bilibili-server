package com.bilibili.gatewayimpl.user;

import com.alibaba.cola.exception.BizException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.bilibili.common.utils.TokenUtils;
import com.bilibili.domain.user.User;
import com.bilibili.domain.user.gateway.UserGateway;
import com.bilibili.gatewayimpl.user.convertor.UserConvertor;
import com.bilibili.gatewayimpl.user.database.UserInfoMapper;
import com.bilibili.gatewayimpl.user.database.UserMapper;
import com.bilibili.gatewayimpl.user.database.dataobject.UserDO;
import com.bilibili.user.dto.data.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Boolean checkByPhone(String phone) {

        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return ObjectUtils.isNotEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    public Boolean checkById(Long id) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return ObjectUtils.isEmpty(userMapper.selectOne(queryWrapper));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void save(User user) {

        if (Objects.isNull(user.getId())) {
            register(user);
            return;
        }
        modify(user);

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void register(User user) {

        UserDO userDO = UserConvertor.toDataObject(user);
        userMapper.insert(userDO);
        userInfoMapper.insert(UserConvertor.toDataObject(userDO));

    }

    @Override
    public void modify(User user) {

    }

    @Override
    public String login(User user) {

        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", user.getPhone().getNumber());
        UserDO userDO = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(userDO)) {
            throw new BizException(ErrorCode.B_USER_phoneNotExit.getErrCode(), ErrorCode.B_USER_phoneNotExit.getErrDesc());
        }

        // 验证
        user.getEncoder().verify(userDO.getPassword(), userDO.getSalt());
        return TokenUtils.generateToken(userDO.getId());

    }
}
