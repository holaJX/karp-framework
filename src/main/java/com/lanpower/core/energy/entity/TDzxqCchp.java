package com.lanpower.core.energy.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 三联供系统
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDzxqCchp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备
     */
    private String device;

    /**
     * 数据时标（格式ISO8601）
     */
    @TableField(value = "date_time")
    private String dateTime;

    /**
     * 电功率
     */
    private String powerE;

    /**
     * 电量
     */
    private String energyE;

    /**
     * 热功率
     */
    private String powerT;

    /**
     * 热量
     */
    private String energyT;

    /**
     * 冷功率
     */
    private String powerC;

    /**
     * 冷量
     */
    private String energyC;

    /**
     * 蒸汽输出功率
     */
    private String powerS;

    /**
     * 蒸汽输出量
     */
    private String energyS;

    /**
     * 天燃气率
     */
    private String powerN;

    /**
     * 天燃气量
     */
    private String energyN;


}
