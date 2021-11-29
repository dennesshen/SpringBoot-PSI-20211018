package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;

@SpringBootTest
public class CreateSupplier {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Test
	void start() {
		
		Supplier supplier1 = new Supplier();
		supplier1.setSupplierName("S1");
		Supplier supplier2 = new Supplier();
		supplier2.setSupplierName("S2");
		Supplier supplier3 = new Supplier();
		supplier3.setSupplierName("S3");
		
		supplierRepository.save(supplier1);
		supplierRepository.save(supplier2);
		supplierRepository.save(supplier3);
		
		
	}

}
