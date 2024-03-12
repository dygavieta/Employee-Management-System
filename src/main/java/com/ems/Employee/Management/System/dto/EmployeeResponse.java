package com.ems.Employee.Management.System.dto;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class EmployeeResponse {

    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String nationality;
    private String occupation;
    private String birthDate;
    private String birthCity;
    private String civilStatus;
    private String contactNumber;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String country;

    private Set<EmergencyContact> lEmergencyContactSet;
    private Set<Role> lRoles;
}
