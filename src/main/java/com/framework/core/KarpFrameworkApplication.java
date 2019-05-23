package com.framework.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.framework.core"})
@MapperScan({"com.framework.core.**.mapper"})
public class KarpFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarpFrameworkApplication.class, args);
	}

}
