package com.example.demo.testing;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
public class CreateOrder {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@Test
	void start() {
		
		Customer customer = customerRepository.findById(1L).get();
		Employee employee = employeeRepository.findById(1L).get();
		Product product1 = productRepository.findById(1L).get();
		Product product2 = productRepository.findById(2L).get();
		
		//建立訂單
		Order order = new Order();
		order.setOrderDate( new Date());
		order.setOrderNumber("0004");
		
		//配置訂單關聯
		order.setCustomer(customer);
		order.setEmployee(employee);

		//建立訂單細目
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setAmount(5);
		orderItem1.setOrder(order);
		orderItem1.setProduct(product1);
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setAmount(7);
		orderItem2.setOrder(order);
		orderItem2.setProduct(product2);
		
		//保存
		orderRepository.save(order);
		orderItemRepository.save(orderItem1);
		orderItemRepository.save(orderItem2);
		
	}

}
