package com.ems.Employee.Management.System.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@Data
@Table(name = "tbl_emergency_contact")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger emergencyContactId;
    private String name;
    private String relationship;
    private String contactNumber;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "emergencyContacts")
    private Set<Employee> employees = new HashSet<>();
}
