package com.ems.Employee.Management.System;

import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.service.employee.EmployeeService;

import static org.assertj.core.api.Assertions.assertThat;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Autowired
	private EmployeeService employeeService;


	@Test
	void whenSavingEmployee_thenOk(){
		Employee employee = new Employee();
		employee.setLastName("Gavieta");
		employee.setFirstName("Don Michael");
		employee.setMiddleName("Yap");
		employee.setFullName("Don Michael Yap Gavieta");
		Employee savedEmployee = employeeService.addEmployee(employee);
 		assertThat(savedEmployee).isNotNull();
	}

	@Test
	void whenDeleteEmployee_thenOk(){
		Employee employee = employeeService.findByFullName("Don Michael Yap Gavieta");
		Employee deletedEmployee = employeeService.deleteById(employee.getEmployeeId());
		assertThat(deletedEmployee).isNotNull();
	}

}
