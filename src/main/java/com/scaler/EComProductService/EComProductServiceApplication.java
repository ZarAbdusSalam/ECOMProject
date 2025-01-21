package com.scaler.EComProductService;

import com.scaler.EComProductService.service.InitService;
import com.scaler.EComProductService.service.InitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EComProductServiceApplication implements CommandLineRunner {

//	@Autowired
	private InitService initService;

	public EComProductServiceApplication(InitService initService) {
		this.initService = initService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EComProductServiceApplication.class, args);
//		run();
	}

//	public static void run() {
//		System.out.println("Hi From Command Line");
//
//	}

//	public void run(String[] args){ -> did not give any data in tables
	public void run(String... args){
		initService.initialise();
	}



}
