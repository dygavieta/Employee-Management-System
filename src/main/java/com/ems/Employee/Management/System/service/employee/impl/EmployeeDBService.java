package com.ems.Employee.Management.System.service.employee.impl;

import com.ems.Employee.Management.System.dto.EmployeeDTO;
import com.ems.Employee.Management.System.dto.EmployeeDTOConverter;
import com.ems.Employee.Management.System.dto.EmployeeResponse;
import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.repository.EmergencyContactRepository;
import com.ems.Employee.Management.System.repository.EmployeeRepository;
import com.ems.Employee.Management.System.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@Profile("prod")
public class EmployeeDBService implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmergencyContactRepository emergencyContactRepository;
    @Override
    public EmployeeDTO findById(BigInteger employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (existingEmployee !=null){
            return EmployeeDTOConverter.convertToDTO(existingEmployee);
        }
        return null;
    }

    @Override
    public Employee findByFullName(String fullName) {
        return employeeRepository.findByFullName(fullName).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeResponse employee) {
        if (employeeRepository.findByFullName(employee.getFullName()).isEmpty()){
            employeeRepository.save(EmployeeDTOConverter.convertToEmployee(employee));
            return employee;
        } else {
            return null; // throw employee already exist
        }
    }

    @Override
    public Employee addEmergencyContact(BigInteger employeeId, EmergencyContact emergencyContact) {
        Employee employee = employeeRepository.findById(employeeId).get();

        Set<EmergencyContact> emergencyContacts = employee.getEmergencyContacts();
        if (emergencyContacts.stream().noneMatch(emergencyContact1 -> emergencyContact1.getContactNumber().equals(emergencyContact.getContactNumber()))){
            emergencyContacts.add(emergencyContact);
            employee.setEmergencyContacts(emergencyContacts);
            emergencyContactRepository.save(emergencyContact);
            return employeeRepository.save(employee);
        }
       return null;
    }

    @Override
    public Employee deleteById(BigInteger employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        if (employee!= null){
            employeeRepository.deleteById(employeeId);
            return employee;
        }
        return null;
    }

    @Override
    public List<Employee> findByCreatedDateBetween(LocalDate start, LocalDate end) {

        return employeeRepository.findByJobStartedBetween(start,end);
    }

    @Override
    public Page<Employee> findByPage(int page, int items, boolean sorted) {
        if (sorted) {
            return employeeRepository.findAll(PageRequest.of(page, items, Sort.by(Sort.Order.asc("lastName"))));
        } else {
            return employeeRepository.findAll(PageRequest.of(page, items));
        }
    }
}
