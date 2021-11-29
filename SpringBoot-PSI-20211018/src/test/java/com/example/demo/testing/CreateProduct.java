package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateProduct {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void start() {
		Product product1 = new Product();
		product1.setProductName("p1");
		product1.setCost(10);
		product1.setPrice(15);
		
		Product product2 = new Product();
		product2.setProductName("p2");
		product2.setCost(20);
		product2.setPrice(25);
		
		Product product3 = new Product();
		product3.setProductName("p3");
		product3.setCost(30);
		product3.setPrice(35);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
	}

}
