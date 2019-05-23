package com.framework.core.cache;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Desrcibe:
 *
 * @Author pujx
 * @Date 2019/3/1 16:40
 */
@Service
@Slf4j
public class RedisCacheServiceImpl implements RedisCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setValueByParamTypeAndParamKey(String paramType, String paramKey, String paramValue) {
        if (StringUtils.isBlank(paramType) || StringUtils.isBlank(paramKey) || StringUtils.isBlank(paramValue)) {
            log.warn("缓存-设置-[type-key-value] : Key和value有值为空!!");
            return;
        } else {
            this.redisTemplate.opsForHash().put(paramType, paramKey, paramValue);
            log.info("---------------> set cache Done...");
        }
    }

    @Override
    public void setValueByParamTypeAndParamKey(String paramType, String paramKey, Object obj) {
        if (StringUtils.isBlank(paramType) || StringUtils.isBlank(paramKey) || obj == null) {
            log.warn("缓存-设置-[type-key-value] : Key和value有值为空!!");
            return;
        } else {
            this.redisTemplate.opsForHash().put(paramType, paramKey, obj);
            log.info("---------------> set cache Done...");
        }
    }

    @Override
    public void setValuesByMap(Map<String, Map<String, String>> InfoMap) {
        if (InfoMap == null || InfoMap.isEmpty()) {
            log.warn("缓存-设置-[type-key-value] : Key于value有值为空!!");
            return;
        } else {
            for (Map.Entry<String, Map<String, String>> mapEntry : InfoMap.entrySet()) {
                String paramType = mapEntry.getKey();
                Map<String, String> paraMap = mapEntry.getValue();

                if (!StringUtils.isBlank(paramType) && !(paraMap == null || paraMap.isEmpty())) {
                    log.info("---------------> set cache By Map Done...");
                    this.redisTemplate.opsForHash().putAll(paramType, paraMap);
                }
            }
        }
    }

    @Override
    public Map<String, String> getMapInfoByParamType(String paramType) {

        if (StringUtils.isBlank(paramType)) {
            log.warn("缓存-获取-[type-key-value] : paramType为空!!");
            return null;
        } else {
            Map<Object, Object> entryMap = this.redisTemplate.opsForHash().entries(paramType);

            if (entryMap == null || entryMap.isEmpty()) {
                return new HashMap<String, String>();
            } else {
                Map<String, String> returnEntryMap = new HashMap<String, String> ();

                for (Map.Entry<Object, Object> entry : entryMap.entrySet()) {
                    returnEntryMap.put((String) entry.getKey(), (String) entry.getValue());
                }
                return returnEntryMap;
            }
        }
    }

    @Override
    public String getValueByParamTypeAndParamKey(String paramType, String paramKey) {
        if (StringUtils.isBlank(paramType) || StringUtils.isBlank(paramKey)) {
            log.warn("缓存-获取-[type-key-value] : paramType 和 paramKey 有值为空!!");
            return null;
        } else {
            return (String) this.redisTemplate.opsForHash().get(paramType, paramKey);
        }
    }

    @Override
    public Object getObjValueByParamTypeAndParamKey(String paramType, String paramKey) {
        if (StringUtils.isBlank(paramType) || StringUtils.isBlank(paramKey)) {
            log.warn("缓存-获取-[type-key-value] : paramType 和 paramKey 有值为空!!");
            return null;
        } else {
            return this.redisTemplate.opsForHash().get(paramType, paramKey);
        }
    }

    @Override
    public boolean deleteValueByParamType(String paramType) {
        if (StringUtils.isBlank(paramType)) {
            log.warn("缓存-删除-[type-key-value]-按Type : paramType值为空!!");
            return false;
        } else {
            return this.redisTemplate.delete(paramType);
        }
    }

    @Override
    public long deleteValueByParamTypeAndParamKey(String paramType, String[] paramKeyArray) {

        if (StringUtils.isBlank(paramType)) {
            log.warn("缓存-删除-[type-key-value]-按Type与Key : paramType值为空!!");
            return -1;
        } else if (paramKeyArray == null || paramKeyArray.length <= 0) {
            log.warn("缓存-删除-[type-key-value]-按Type与Key : paramKey值为空!!");
            return -1;
        } else {
            return this.redisTemplate.opsForHash().delete(paramType, paramKeyArray);
        }

    }

}
