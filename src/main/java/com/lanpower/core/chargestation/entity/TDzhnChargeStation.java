package com.lanpower.core.chargestation.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 充电站数据表
 * </p>
 *
 * @author pujx
 * @since 2020-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TDzhnChargeStation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 无卡启动流水号
     */
    private String noCardStartSerialNum;

    /**
     * 有卡启动流水号
     */
    private String cardStartSerialNum;

    /**
     * 第三方平台启动流水号
     */
    private String thirdPlatformStartSerialNum;

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 充电桩编码
     */
    private String chargePileCode;

    /**
     * 运营商名称
     */
    private String operatorName;

    /**
     * 电卡大客户
     */
    private String cardBigCustomer;

    /**
     * 充电模式
     */
    private String chargingMode;

    /**
     * 启动平台
     */
    private String launchPlatform;

    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 车辆VIN码
     */
    private String carVinCode;

    /**
     * 车牌号
     */
    private String numberPlate;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 开始充电时间
     */
    private LocalDateTime startChargeTime;

    /**
     * 充电持续时间(s)
     */
    private String chargingDuration;

    /**
     * 尖充电度数
     */
    private String pointChargeDegree;

    /**
     * 尖电费
     */
    private String sharpElectricityFee;

    /**
     * 尖服务费
     */
    private String sharpServiceFee;

    /**
     * 尖充电时间(s)
     */
    private String sharpChargingTime;

    /**
     * 峰充电度数
     */
    private String peakChargeDegree;

    /**
     * 峰电费
     */
    private String peakElectricityFee;

    /**
     * 峰服务费
     */
    private String peakServiceFee;

    /**
     * 峰充电时间(s)
     */
    private String peakChargingTime;

    /**
     * 平充电度数
     */
    private String flatChargeDegree;

    /**
     * 平电费
     */
    private String flatElectricityFee;

    /**
     * 平服务费
     */
    private String flatServiceFee;

    /**
     * 平充电时间(s)
     */
    private String flatChargingTime;

    /**
     * 谷充电度数
     */
    private String valleyChargeDegree;

    /**
     * 谷电费
     */
    private String valleyElectricityFee;

    /**
     * 谷服务费
     */
    private String valleyServiceFee;

    /**
     * 谷充电时间(s)
     */
    private String valleyChargingTime;

    /**
     * 总充电度数
     */
    private BigDecimal totalChargeDegree;


}
