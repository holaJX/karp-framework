package com.lanpower.core.usercore.service;

import com.lanpower.core.usercore.entity.CoreDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lanpower.core.usercore.entity.CoreDict;

import java.util.Map;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author pujx
 * @since 2019-05-22
 */
public interface ICoreDictService extends IService<CoreDict> {
    void setAllCustSysDictInCache();
    Map<String, String> getCustSysDictByTypeFromDB(String paramType, boolean isUpdateCache);

    Map<String, String> getCustSysDictByType(String paramType);
}
