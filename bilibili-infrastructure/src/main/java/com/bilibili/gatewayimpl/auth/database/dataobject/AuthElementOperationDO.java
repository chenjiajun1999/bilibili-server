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
 * 权限控制--页面元素操作表
 *
 * @author Jiajun Chen
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value= "t_auth_element_operation")
public class AuthElementOperationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 页面元素名称
     */
    @TableField("elementName")
    private String elementName;

    /**
     * 页面元素唯一编码
     */
    @TableField("elementCode")
    private String elementCode;

    /**
     * 操作类型：0可点击  1可见
     */
    @TableField("operationType")
    private String operationType;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;


}
