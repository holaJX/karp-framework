package com.lanpower.core.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: pujx
 * @Date: 2019/5/22 15:58
 */
@Component(value = "testScheduled")
@Slf4j
public class TestScheduled {




    @Scheduled(cron = "0 0/5 * * * ?")
    public void cleanCaptcha() {
        // cron = "0 0/5 * * * ?" 每小时的第0分0秒开始，每5分钟触发一次
        // cron = "0/10 * * * * ?" 每小时的第0分0秒开始，每10秒触发一次
        log.info("计划任务-在时间间隔内是否清除过期的验证码记录标志 : " );


    }
}