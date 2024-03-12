package com.ems.Employee.Management.System.service.employee;

import com.ems.Employee.Management.System.dto.EmployeeDTO;
import com.ems.Employee.Management.System.dto.EmployeeResponse;
import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO findById(BigInteger employeeId);
    Employee findByFullName(String fullName);
    List<Employee> getAll();
    EmployeeResponse addEmployee(EmployeeResponse employee);
    Employee addEmergencyContact(BigInteger employeeId, EmergencyContact emergencyContact);
    Employee deleteById(BigInteger employeeId);

    List<Employee> findByCreatedDateBetween(LocalDate start, LocalDate end);

    Page<Employee> findByPage(int items, int page, boolean sorted);
}
