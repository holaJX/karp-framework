package com.lanpower.core.usercore.vo;

import lombok.Data;

/**
 * @Author: pujx
 * @Date: 2019/5/22 17:18
 */
@Data
public class CoreDictVO {
    /**
     * 字典参数
     */

    private String paramKey;
    /**
     * 字典值
     */
    private String paramValue;

    public CoreDictVO(String paramKey, String paramValue) {
        this.paramKey = paramKey;
        this.paramValue = paramValue;
    }
}
