package com.bilibili.gatewayimpl.auth.database.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限控制--角色与元素操作关联表
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value= "t_auth_role_element_operation")
public class AuthRoleElementOperationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    @TableField("roleId")
    private Long roleId;

    /**
     * 元素操作id
     */
    @TableField("elementOperationId")
    private Long elementOperationId;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
