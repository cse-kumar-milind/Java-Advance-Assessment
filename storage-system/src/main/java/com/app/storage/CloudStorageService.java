package com.app.storage;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Scope("singleton")
@Primary
public class CloudStorageService implements StorageService {
	
	public CloudStorageService() {
		System.out.println("\nCloudStorageService Bean Created!\n");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("\nCloudStorageService Bean Initialized\n");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("\nCloudStorageService Bean Destroyed\n");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("\nFile stored in Cloud Storage : "+fileName);
	}
}
