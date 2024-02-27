package com.ems.Employee.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger employeeId;
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
    private String createdDate;
    private String modifiedDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_employee_emergency_contact",
            joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "emergencyContactId", referencedColumnName = "emergencyContactId")
    )
    private Set<EmergencyContact> emergencyContacts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_employee_role",
            joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    )
    private Set<Role> roles = new HashSet<>();
}
