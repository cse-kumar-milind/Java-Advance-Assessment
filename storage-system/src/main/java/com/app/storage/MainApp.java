package com.app.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.app.storage")
public class MainApp {
	public static void main(String[] args) {
		
		System.out.println("\nStarting Container...\n");
		
		ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);;
		
		System.out.println("\nContainer Started!\n");
		
		StorageService storage = context.getBean(StorageService.class);
		storage.storeFile("data.txt");
		
		StorageService localService1 = context.getBean("localStorage", StorageService.class);
		
		
		StorageService localService2 = context.getBean("localStorage", StorageService.class);
		
		context.close();
		
		System.out.println("\nContainer closed!");
		
		
	}
}
