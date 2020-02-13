package com.lanpower.core.chargestation.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 滇中汇能充电桩设备信息
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDzhnChargeEquipmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 所属站点
     */
    private String site;

    /**
     * 桩编码
     */
    private String chargePileCode;

    /**
     * 桩厂商
     */
    private String chargePileManufacturers;

    /**
     * 终端号
     */
    private String terminalNumber;

    /**
     * 桩型号
     */
    private String chargePileModel;

    /**
     * 类型
     */
    private String type;

    /**
     * 额定功率
     */
    private Integer ratedPower;

    /**
     * 额定电流
     */
    private Integer ratedCurrent;

    /**
     * 额定电压
     */
    private Integer ratedVoltage;

    /**
     * 接入时间
     */
    private String accessTime;

    /**
     * 充电口数
     */
    private Integer chargePortNumber;

    /**
     * 充电桩描述
     */
    private String chargePileDescription;


}
