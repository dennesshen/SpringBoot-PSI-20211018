package com.example.demo.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
public class CreateEmployee {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Test
	void start() {
		
		System.out.println("testStart");
		Department D1 = departmentRepository.findById(2L).get();
		Department D2 = departmentRepository.findById(3L).get();
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("John");
		
		Employee employee2 = new Employee();
		employee2.setEmployeeName("Mary");
		
		employee1.setDepartment(D1);
		employee2.setDepartment(D2);
		
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

		
		
		
	}

}
