package com.ems.Employee.Management.System.service.employee.impl;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.service.employee.EmployeeService;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("dev")
@Setter
public class EmployeeNonDBService implements EmployeeService {

    private List<Employee> employeeList;
    private BigInteger index;

    public EmployeeNonDBService(){
        this.employeeList = new ArrayList<>();
        this.index = BigInteger.ONE;
    }
    @Override
    public Employee findById(BigInteger employeeId) {

        return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElse(null);
    }

    @Override
    public Employee findByFullName(String fullName) {
        return employeeList.stream().filter(employee -> employee.getFullName().equals(fullName)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        boolean existing = employeeList.stream().anyMatch(existingEmployee -> existingEmployee.getFullName().equals(employee.getFullName()));

        if (!existing){
            employee.setEmployeeId(index);
            employeeList.add(employee);
            this.setIndex(index.add(BigInteger.ONE));
            return employee;
        } {
            return null;
            /*
            throw existingEmployee
             */
        }
    }


    @Override
    public Employee addEmergencyContact(BigInteger employeeId, EmergencyContact emergencyContact) {
        return null;
    }
}
