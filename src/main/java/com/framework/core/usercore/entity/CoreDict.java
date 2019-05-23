package com.framework.core.usercore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author pujx
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoreDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("VALUE")
    private String value;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 字典编码
     */
    @TableField("TYPE")
    private String type;

    /**
     * 类型描述
     */
    @TableField("TYPE_NAME")
    private String typeName;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 父id
     */
    @TableField("PARENT")
    private Integer parent;

    /**
     * 删除标记
     */
    @TableField("DEL_FLAG")
    private Integer delFlag;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;


}
