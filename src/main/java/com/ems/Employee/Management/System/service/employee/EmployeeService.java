package com.ems.Employee.Management.System.service.employee;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeService {
    Employee findById(BigInteger employeeId);

    Employee findByFullName(String fullName);
    List<Employee> getAll();
    Employee addEmployee(Employee employee);

    Employee addEmergencyContact(BigInteger employeeId, EmergencyContact emergencyContact);

}
