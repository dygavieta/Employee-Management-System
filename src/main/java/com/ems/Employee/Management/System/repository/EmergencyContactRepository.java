package com.ems.Employee.Management.System.repository;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, BigInteger> {

    Optional<EmergencyContact> findByContactNumber(String contactNumber);
}
