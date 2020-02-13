package com.lanpower.core.energy.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lanpower.core.common.ResponseDTO;

import com.lanpower.core.energy.entity.TDzxqEnergyStructure;
import com.lanpower.core.energy.entity.TDzxqPv;
import com.lanpower.core.energy.service.ITDzxqEnergyStructureService;
import com.lanpower.core.energy.service.ITDzxqPvService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 * @Author: pujx
 * @Date: 2019/5/22 15:04
 */
@Slf4j
@RestController
@RequestMapping("/pvenergy")
public class PvEnergyCenterController {
    @Autowired
    private ITDzxqPvService itDzxqPvService;

    @Autowired
    private ITDzxqEnergyStructureService  itDzxqEnergyStructureService;
    /**
     * 查询光伏数据
     * @return
     */
    @GetMapping("structure")
    public ResponseDTO getUser() {
       // int pageIndex=0;
        //int pageSize=10;
     //  // Page<TDzxqPv> page = new Page<>(pageIndex, pageSize);
      List<TDzxqEnergyStructure> list = itDzxqEnergyStructureService.list();
        return ResponseDTO.success(list);
    }

}
