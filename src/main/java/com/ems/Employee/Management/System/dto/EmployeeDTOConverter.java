package com.ems.Employee.Management.System.dto;

import com.ems.Employee.Management.System.entity.Employee;

import java.time.LocalDate;

public class EmployeeDTOConverter {

    public static EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setContactNumber(employee.getContactNumber());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setFirstName(employee.getFirstName());

        return employeeDTO;
    }
    public static Employee convertToEmployee(EmployeeResponse employee){
        Employee mapEmployee = new Employee();

        mapEmployee.setFirstName(employee.getFirstName());
        mapEmployee.setMiddleName(employee.getMiddleName());
        mapEmployee.setLastName(employee.getLastName()); // Corrected from "this.lastName" to "employee.getLastName()"
        mapEmployee.setFullName(employee.getFullName());
        mapEmployee.setNationality(employee.getNationality());
        mapEmployee.setOccupation(employee.getOccupation());
        mapEmployee.setBirthDate(employee.getBirthDate());
        mapEmployee.setBirthCity(employee.getBirthCity());
        mapEmployee.setCivilStatus(employee.getCivilStatus());
        mapEmployee.setContactNumber(employee.getContactNumber());
        mapEmployee.setAddressLine1(employee.getAddressLine1());
        mapEmployee.setAddressLine2(employee.getAddressLine2());
        mapEmployee.setZipCode(employee.getZipCode());
        mapEmployee.setCountry(employee.getCountry());
        mapEmployee.setCreatedDate(LocalDate.now().toString());
        mapEmployee.setModifiedDate(LocalDate.now().toString());
        mapEmployee.setJobStarted(LocalDate.now());

        mapEmployee.setEmergencyContacts(employee.getLEmergencyContactSet());
        mapEmployee.setRoles(employee.getLRoles());

        return mapEmployee;
    }

}
