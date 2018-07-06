package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {


	@RequestMapping(value = "/hello")
	public String ddd(){
		return "dhjuwqheuiwqh";
	}
	@RequestMapping(value = "/xxx")
	public String dddd(){
		return "dwswqnsdqwiuneuihwnquehjuiqwjeiujqwioejiqwjeoijqwoijeoiqwjoiej";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
