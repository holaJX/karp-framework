package com.lanpower.core.usercore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author pujx
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("users")
public class CoreUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("CODE")
    private String code;

    @TableField("NAME")
    private String name;

    @TableField("PASSWORD")
    private String password;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("ORG_ID")
    private Integer orgId;

    /**
     * 用户状态 1:启用 0:停用
     */
    @TableField("STATE")
    private String state;

    @TableField("JOB_TYPE1")
    private String jobType1;

    /**
     * 用户删除标记 0:未删除 1:已删除
     */
    @TableField("DEL_FLAG")
    private Integer delFlag;

    @TableField("update_Time")
    private Date updateTime;

    @TableField("JOB_TYPE0")
    private String jobType0;

    @TableField("attachment_id")
    private String attachmentId;


}
