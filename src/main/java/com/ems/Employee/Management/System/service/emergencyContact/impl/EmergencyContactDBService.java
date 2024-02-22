package com.ems.Employee.Management.System.service.emergencyContact.impl;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.repository.EmergencyContactRepository;
import com.ems.Employee.Management.System.repository.EmployeeRepository;
import com.ems.Employee.Management.System.service.emergencyContact.EmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class EmergencyContactDBService implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmergencyContact findById(BigInteger id) {
        return emergencyContactRepository.findById(id).orElse(null);
    }


    @Override
    public EmergencyContact findByContactNumber(String contactNumber) {
        return emergencyContactRepository.findByContactNumber(contactNumber).orElse(null);
    }
}
