package com.ems.Employee.Management.System.service.employee.impl;

import com.ems.Employee.Management.System.dto.EmployeeDTO;
import com.ems.Employee.Management.System.dto.EmployeeDTOConverter;
import com.ems.Employee.Management.System.dto.EmployeeResponse;
import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.service.employee.EmployeeService;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
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
    public EmployeeDTO findById(BigInteger employeeId) {

        Employee existingEmployee = employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElse(null);
        if (existingEmployee !=null){
           return EmployeeDTOConverter.convertToDTO(existingEmployee);
        }
        return null;
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
    public EmployeeResponse addEmployee(EmployeeResponse employee) {
        boolean existing = employeeList.stream().anyMatch(existingEmployee -> existingEmployee.getFullName().equals(employee.getFullName()));

        if (!existing){
            Employee employee1 = EmployeeDTOConverter.convertToEmployee(employee);
            employee1.setEmployeeId(index);
            employeeList.add(employee1);
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

    @Override
    public Employee deleteById(BigInteger employeeId) {
        return null;
    }

    @Override
    public List<Employee> findByCreatedDateBetween(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public Page<Employee> findByPage(int items, int page, boolean sorted) {
        return null;
    }
}
