package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootTest
public class CreateCustomer {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void start() {
		
		Customer customer1 = new Customer();
		customer1.setCustomerName("C1");
		
		Customer customer2 = new Customer();
		customer2.setCustomerName("C2");
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);

	}

}
