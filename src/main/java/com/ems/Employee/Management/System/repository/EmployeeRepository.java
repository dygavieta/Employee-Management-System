package com.ems.Employee.Management.System.repository;

import com.ems.Employee.Management.System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

    Optional<Employee> findById(BigInteger employeeId);
    Optional<Employee> findByFullName(String fullName);
}
