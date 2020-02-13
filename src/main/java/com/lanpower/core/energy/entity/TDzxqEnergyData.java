package com.lanpower.core.energy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_dzxq_energy_data")
public class TDzxqEnergyData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer thingId;

    private Integer timeStamp;

    private String value;


}
