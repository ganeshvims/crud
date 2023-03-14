package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class NavApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavApplication.class, args);
	}

}
