package com.ems.Employee.Management.System.service.emergencyContact;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;

import java.math.BigInteger;

public interface EmergencyContactService {
    EmergencyContact findById(BigInteger id);
    EmergencyContact findByContactNumber(String contactNumber);
}
