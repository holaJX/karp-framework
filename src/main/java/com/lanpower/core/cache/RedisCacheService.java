package com.lanpower.core.cache;

import java.util.Map;

/**
 * Desrcibe:
 *
 * @Author pujx
 * @Date 2019/3/1 15:59
 */
public interface RedisCacheService {


    /**
     * 把 变量存入 Redis Cache
     * @param paramType     参数类型
     * @param paramKey      字典参数
     * @param paramValue    字典值
     */
     void setValueByParamTypeAndParamKey(String paramType, String paramKey, String paramValue);

    /**
     * 把对象 存入 RdisCache
     * @param paramType
     * @param paramKey
     * @param obj
     */
     void setValueByParamTypeAndParamKey(String paramType, String paramKey, Object obj);

    /**
     * 把多个 变量 存入 Redis Cache
     *
     * @param InfoMap {'paramType':{'paramKey':'paramValue'}, ... 'paramType':{'paramKey':'paramValue'}}
     */
     void setValuesByMap(Map<String, Map<String, String>> InfoMap);

    /**
     * 从 Redis Cache 获取 某类型参数
     * @param paramType 参数类型
     * @return {paramKey:paramValue, ... ... paramKey:paramValue}]
     */
     Map<String, String> getMapInfoByParamType(String paramType);



    /**
     * 从 Redis Cache 获取 中某字典参数
     * @param paramType 参数类型
     * @param paramKey  字典参数
     * @return paramValue
     */
     String getValueByParamTypeAndParamKey(String paramType, String paramKey);

    /**
     * 从 Redis Cache 获取 对象数据
     * @param paramType 参数类型
     * @param paramKey  字典参数
     * @return Cahce Obj
     */
     Object getObjValueByParamTypeAndParamKey(String paramType, String paramKey);

    /**
     * 从 Redis Cache 删除 某类型参数
     * @param paramType 参数类型
     * @return [true | false]
     */
     boolean deleteValueByParamType(String paramType);

    /**
     * 从 Redis Cache 删除 CustSysDict(系统字典表) 某字典参数
     * @param paramType 参数类型
     * @param paramKeyArray  字典参数, 字符串数组
     * @return 删除的记录数
     */
     long deleteValueByParamTypeAndParamKey(String paramType, String[] paramKeyArray);

}
