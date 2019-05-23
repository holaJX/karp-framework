package com.framework.core.usercore.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.framework.core.cache.RedisCacheService;
import com.framework.core.usercore.entity.CoreDict;
import com.framework.core.usercore.mapper.CoreDictMapper;
import com.framework.core.usercore.service.ICoreDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author pujx
 * @since 2019-05-22
 */
@Slf4j
@Service
public class CoreDictServiceImpl extends ServiceImpl<CoreDictMapper, CoreDict> implements ICoreDictService {

    @Autowired
    private RedisCacheService redisCacheService;

    /**
     * 把字典表中 ParamType 和 ParamKey不为空的值设置到Cache中
     */
    @Override
    public void setAllCustSysDictInCache() {
        List<CoreDict> custSysDictList = this.list();

        if (custSysDictList == null || custSysDictList.size() <= 0) {
            log.warn("setAllCustSysDictInCache-CustSysDict为空......");
            return;
        } else {
            List<String> paramTypeList = custSysDictList.stream().map(e -> e.getType()).distinct().collect(Collectors.toList());
            Map<String, Map<String, String>> custSysDictMap = new HashMap<String, Map<String, String>>();
            Map<String, List<CoreDict>> collect = custSysDictList.stream().collect(Collectors.groupingBy(e -> e.getType()));
            for ( String key:collect.keySet()
                 ) {
                 List<CoreDict> coreDicts = collect.get(key);
                 //注意使用sorted 时字段为null抛异常
                List<CoreDict> collect1 = coreDicts.parallelStream().sorted( Comparator.comparing(CoreDict ::getSort)).collect(Collectors.toList());
                HashMap<String, String> stringStringHashMap = new LinkedHashMap<>();
                for ( CoreDict dic :collect1
                     ) {
                    stringStringHashMap.put(dic.getValue(),dic.getName());
                }
                custSysDictMap.put(key,stringStringHashMap);

            }

            this.redisCacheService.setValuesByMap(custSysDictMap);
            log.info("setAllCustSysDictInCache-Doen... ...");
        }
    }

    /**
     * 通过Type获取字典值, 先从Cache中获取, 没获取到则查询数据库, 从数据库中查询到值后会设置到Cache中
     * @param paramType 类型
     * @return @return {paramKey:paramValue, ... ... ,paramKey:paramValue}
     */
    @Override
    public Map<String, String> getCustSysDictByType(String paramType) {

        Map<String, String> paramValueMap = this.getCustSysDictByTypeFromCache(paramType);

        if (null == paramValueMap || paramValueMap.isEmpty()) {
            log.info("getCustSysDictByType-未从缓存获取到值, 查询数据库并更新缓存...");
            paramValueMap = this.getCustSysDictByTypeFromDB(paramType, true);
        }
        return paramValueMap;
    }
    /**
     * 从Cache中获取Type类型字典值集合
     * @param paramType
     * @return {paramKey:paramValue, ... ... ,paramKey:paramValue}
     */
    public Map<String, String> getCustSysDictByTypeFromCache(String paramType) {

        if (!StringUtils.isBlank(paramType)) {
            return this.redisCacheService.getMapInfoByParamType(paramType);
        } else {
            log.warn("getCustSysDictByType-ParamType is Null ... ...");
            return null;
        }
    }

    /**
     * 通过Type从数据库中查询该类别的字典集合
     * @param paramType
     * @param isUpdateCache 查询到数据后是否更新Cache, 若为true 查询结束后会删除先删除Cache中的值, 查询到的值不为空则设置到Cache中
     * @return {paramKey:paramValue, ... ... ,paramKey:paramValue}
     */
    @Override
    public Map<String, String> getCustSysDictByTypeFromDB(String paramType, boolean isUpdateCache) {

        log.info("getCustSysDictByTypeFromDB--{type:" + paramType + ", isUpdateCache:" + isUpdateCache + "}");
        // 从数据库查询
        QueryWrapper<CoreDict> coreDictQueryWrapper = new QueryWrapper<>();
        coreDictQueryWrapper.eq("TYPE",paramType);
        List<CoreDict> custSysDictList = baseMapper.selectList(coreDictQueryWrapper);
        Map<String, String> returnMap =new LinkedHashMap<>();
        List<CoreDict> collect = custSysDictList.parallelStream().sorted(Comparator.comparing(CoreDict::getSort)).collect(Collectors.toList());
        // 提取数据
        for (CoreDict custSysDict : collect) {
            if(!StringUtils.isBlank(custSysDict.getValue())) {
                returnMap.put(custSysDict.getValue(), custSysDict.getName());
            }
        }

        // 重设缓存
        if (isUpdateCache && !StringUtils.isBlank(paramType)) {
            // 重设缓存
            // 查询结束后会删除先删除Cache中的值, 查询到的值不为空则设置到Cache中

            log.info("getCustSysDictByTypeFromDB-update cache... ...");
            // 删除缓存
            this.deleteCustSysDictByTypeInCache(paramType);

            // 数据不为空则存入缓存
            if (!returnMap.isEmpty()) {
                Map<String, Map<String, String>> typeMap = new HashMap<String, Map<String, String>>();
                typeMap.put(paramType, returnMap);
                this.redisCacheService.setValuesByMap(typeMap);
            }
        }
        return returnMap;
    }
    /**
     * 删除(清空)Cache中所有某种类型字典值
     * @param paramType
     * @return
     */
    private boolean deleteCustSysDictByTypeInCache(String paramType) {

        return this.redisCacheService.deleteValueByParamType(paramType);
    }
}
