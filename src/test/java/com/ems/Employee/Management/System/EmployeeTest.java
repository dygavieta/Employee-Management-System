package com.ems.Employee.Management.System;

import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.service.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;

    @Value("${lastName}")
    private String lastName;
    @Value("${firstName}")
    private String firstName;
    @Value("${middleName}")
    private String middleName;

    @Test
    void whenSavingEmployee_thenOk(){
//        Employee employee = new Employee();
//        employee.setLastName(this.lastName);
//        employee.setFirstName(this.firstName);
//        employee.setMiddleName(this.middleName);
//        employee.setFullName("Don Michael Yap Gavieta");
//        Employee savedEmployee = employeeService.addEmployee(employee);
//        assertThat(savedEmployee).isNotNull();
    }

    @Test
    void whenGettingNameEmployee_thenOk(){
        Employee employee = employeeService.findByFullName("Don Michael Yap Gavieta");
        assertThat(employee.getFirstName()).isEqualTo(this.firstName);
        assertThat(employee.getLastName()).isEqualTo(this.lastName);
        assertThat(employee.getMiddleName()).isEqualTo(this.middleName);
    }

    @Test
    void whenDeleteEmployee_thenOk(){
        Employee employee = employeeService.findByFullName("Don Michael Yap Gavieta");
        Employee deletedEmployee = employeeService.deleteById(employee.getEmployeeId());
        assertThat(deletedEmployee).isNotNull();
    }
}
