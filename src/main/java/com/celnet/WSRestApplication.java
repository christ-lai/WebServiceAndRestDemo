package com.celnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WSRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WSRestApplication.class, args);
		System.out.println("*****************************");
		System.out.println("*******双协议服务启动成功**********");
		System.out.println("*****************************");
	}
}
