package com.ahearts.yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.ahearts.yx.mapper")
public class YxApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(YxApplication.class, args);
	}

}
