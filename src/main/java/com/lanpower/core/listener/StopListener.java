package com.lanpower.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: pujx
 * @Date: 2019/5/22 15:52
 */
@Slf4j
@Component
public class StopListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
      log.info("KarpFrameworkApplication is stop..........");
    }
}
