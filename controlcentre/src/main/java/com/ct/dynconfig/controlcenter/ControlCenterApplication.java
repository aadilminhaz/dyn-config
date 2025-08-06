package com.ct.dynconfig.controlcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ct")
public class ControlCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlCenterApplication.class, args);
	}

}
