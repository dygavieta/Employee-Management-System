package com.ems.Employee.Management.System.repository;

import com.ems.Employee.Management.System.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, BigInteger> {

    Optional<Role> findByRole(String role);
}
