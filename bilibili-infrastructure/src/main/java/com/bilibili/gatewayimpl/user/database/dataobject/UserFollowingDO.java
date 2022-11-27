package com.bilibili.gatewayimpl.user.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户关注表
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value= "t_user_following")
public class UserFollowingDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Long userId;

    /**
     * 关注用户id
     */
    @TableField("followingId")
    private Integer followingId;

    /**
     * 关注分组id
     */
    @TableField("groupId")
    private Integer groupId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
