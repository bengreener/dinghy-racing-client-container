package com.bginfosys.dinghyracingclientcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DinghyRacingClientContainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinghyRacingClientContainerApplication.class, args);
	}

}
