package com.example.demo.testing;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.entity.PurchaseItem;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.SupplierRepository;

@SpringBootTest
public class CreatePurchase {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseItemRepository purchaseItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	
	@Test
	void start() {
		
		Supplier supplier = supplierRepository.findById(1L).get();
		Employee employee = employeeRepository.findById(1L).get();
		Product product1 = productRepository.findById(1L).get();
		Product product2 = productRepository.findById(2L).get();
		
		//建立採購單
		Purchase purchase = new Purchase();
		purchase.setPurchaseDate(new Date());
		purchase.setPurchaseNumber("0001");
		
		//配置訂單關聯
		purchase.setSupplier(supplier);
		purchase.setEmployee(employee);

		//建立訂單細目
		PurchaseItem purchaseItem1 = new PurchaseItem();
		purchaseItem1.setAmount(500);
		purchaseItem1.setProduct(product1);
		purchaseItem1.setPurchase(purchase);
		
		PurchaseItem purchaseItem2 = new PurchaseItem();
		purchaseItem2.setAmount(700);
		purchaseItem2.setProduct(product2);
		purchaseItem2.setPurchase(purchase);

		
		//保存
		purchaseRepository.save(purchase);
		purchaseItemRepository.save(purchaseItem1);
		purchaseItemRepository.save(purchaseItem2);
		
		
	}

}
