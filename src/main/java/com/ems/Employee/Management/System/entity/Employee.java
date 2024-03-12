package com.ems.Employee.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger employeeId;

    @NotBlank(message = "firstName can't be null")
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
    private LocalDate jobStarted;

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
