package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@SpringBootTest
public class CreateDepartment {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	void start() {
		
		Department department1 = new Department();
		department1.setDepartmentName("採購部");
		Department department2 = new Department();
		department2.setDepartmentName("業務部");
		
		departmentRepository.save(department2);
		
	}

}
