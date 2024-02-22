package com.ems.Employee.Management.System.service.employee.impl;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.repository.EmergencyContactRepository;
import com.ems.Employee.Management.System.repository.EmployeeRepository;
import com.ems.Employee.Management.System.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Profile("prod")
public class EmployeeDBService implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmergencyContactRepository emergencyContactRepository;
    @Override
    public Employee findById(BigInteger employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
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
    public Employee addEmployee(Employee employee) {
        if (employeeRepository.findByFullName(employee.getFullName()).isEmpty()){
            return employeeRepository.save(employee);
        } else {
            return null; // throw employee already exist
        }
    }

    @Override
    public Employee addEmergencyContact(BigInteger employeeId, EmergencyContact emergencyContact) {
        Employee employee = findById(employeeId);

        Set<EmergencyContact> emergencyContacts = employee.getEmergencyContacts();
        if (emergencyContacts.stream().noneMatch(emergencyContact1 -> emergencyContact1.getContactNumber().equals(emergencyContact.getContactNumber()))){
            emergencyContacts.add(emergencyContact);
            employee.setEmergencyContacts(emergencyContacts);
            emergencyContactRepository.save(emergencyContact);
            return employeeRepository.save(employee);
        }
       return null;
    }
}
