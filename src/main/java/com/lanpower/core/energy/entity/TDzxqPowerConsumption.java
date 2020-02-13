package com.lanpower.core.energy.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 滇中新港智能制造产业园电耗数据表
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDzxqPowerConsumption implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 能源结构id
     */
    private Integer thingId;

    /**
     * 时间(按月统计)
     */
    private String timeMonth;

    /**
     * 电耗值
     */
    private String powerConsumptionValue;


}
