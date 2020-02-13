package com.lanpower.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan //druid监控页面是一个servlet，需要让SpingBoot支持servlet.在程序入口添加注解
@SpringBootApplication
@ComponentScan({"com.lanpower.core"})
@MapperScan({"com.lanpower.core.**.mapper"})
public class KarpFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarpFrameworkApplication.class, args);
	}

}
