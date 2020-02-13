package com.lanpower.core.usercore.controller;

import com.lanpower.core.common.ResponseDTO;
import com.lanpower.core.usercore.service.ICoreDictService;
import com.lanpower.core.usercore.vo.CoreDictVO;
import com.lanpower.core.common.ResponseDTO;
import com.lanpower.core.usercore.service.ICoreDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: pujx
 * @Date: 2019/5/22 17:16
 */
@RestController
@RequestMapping("/dic")
public class DicController {

    @Autowired
    private ICoreDictService coreDictService;
    /**
     * 根据类型查询字典
     * @param paramType  业务类型
     * @return
     */
    @GetMapping(value = "/findListByType")
    public ResponseDTO getSysDictListByType(
            @RequestParam("paramType") String paramType
    ) {
        try {
            if (StringUtils.isBlank(paramType)) {
                return ResponseDTO.failed("参数不能为空！");
            }
            Map<String, String> custSysDictParamValue = coreDictService.getCustSysDictByType(paramType);
            List<CoreDictVO> list=new ArrayList<>();
            for (String key: custSysDictParamValue.keySet()
                    ) {
                CoreDictVO custSysDictVo = new CoreDictVO(key,custSysDictParamValue.get(key));
                list.add(custSysDictVo);
            }
            return ResponseDTO.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.failed("查询失败!");
        }
    }
}
