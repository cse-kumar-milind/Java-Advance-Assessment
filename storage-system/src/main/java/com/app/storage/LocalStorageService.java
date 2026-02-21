package com.app.storage;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Scope("prototype")
@Lazy
public class LocalStorageService implements StorageService {
	
	public LocalStorageService() {
		System.out.println("\nLocalStorageService Bean Created!\n");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("\nFile stored in Local Storage : "+ fileName);
	}

}
