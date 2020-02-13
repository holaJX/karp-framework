package com.lanpower.core.listener;

import com.lanpower.core.usercore.service.ICoreDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: pujx
 * @Date: 2019/5/22 15:54
 */
@Slf4j
@Component
public class LoaderRunner implements CommandLineRunner {

    @Autowired
    private ICoreDictService coreDictService;

    @Value("${customer.isLoadCustSysDict}")
    private String isLoadCustSysDict;
    @Override
    public void run(String... args) throws Exception {
//        log.info("KarpFrameworkApplication is start..........");
//        log.info("项目启动, 是否加载数据字典表到Cache 标志 : " + this.isLoadCustSysDict);
//        if ("true".equals(this.isLoadCustSysDict)) {
//            log.info("项目启动, 加载数据字典表到Cache ... Start ...");
//            this.coreDictService.setAllCustSysDictInCache();
//            log.info("项目启动, 加载数据字典表到Cache ...  End  ...");
//        }
    }
}
