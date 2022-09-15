package com.omnipotent.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot 启动类
 * @author yuxue
 * @date 2019-12-06
 */
@SpringBootApplication
@MapperScan("com.omnipotent.work.mapper")
public class Application {

	public static void main(String[] args) {
		    SpringApplication.run(com.omnipotent.work.Application.class, args);
	}
}
