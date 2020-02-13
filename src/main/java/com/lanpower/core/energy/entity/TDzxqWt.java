package com.lanpower.core.energy.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 风机
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDzxqWt implements Serializable {

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
     * 功率
     */
    private String power;

    /**
     * 电量
     */
    private String energy;


}
