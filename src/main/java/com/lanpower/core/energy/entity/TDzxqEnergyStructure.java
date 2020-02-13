package com.lanpower.core.energy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 滇中新区能源结构表
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_dzxq_energy_structure")
public class TDzxqEnergyStructure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 能源生产/消耗一级分类
     */
    private String level1;

    /**
     * 光伏、储能、工业楼宇等二级分类
     */
    private String level2;

    /**
     * 分布式光伏、能源中心、滇中办公区等三级分类
     */
    private String level3;

    /**
     * 滇中新区管委会大楼、风力发电系统等四级分类
     */
    private String level4;

    /**
     * 屋顶光伏、风机1等五级分类
     */
    private String level5;

    /**
     * 风机相关数据、电耗等六级分类
     */
    private String level6;

    /**
     * 数据名称
     */
    @TableField(value = "data_name")
    private String dataName;

    /**
     * 备注
     */
    private String remark;


}
