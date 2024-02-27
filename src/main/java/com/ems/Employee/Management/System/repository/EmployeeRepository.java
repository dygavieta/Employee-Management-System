package com.ems.Employee.Management.System.repository;

import com.ems.Employee.Management.System.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {

    Optional<Employee> findById(BigInteger employeeId);
    Optional<Employee> findByFullName(String fullName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_employee_emergency_contact WHERE employee_id = ?1", nativeQuery = true)
    void deleteEmployeeEmergencyContact(BigInteger employeeId);
}
