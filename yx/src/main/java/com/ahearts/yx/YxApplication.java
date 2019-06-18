package com.ahearts.yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
@MapperScan("com.ahearts.yx.mapper")
public class YxApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(YxApplication.class);
        application.addListeners(new PropertiesConfig());
        application.run(args);
	}

}
