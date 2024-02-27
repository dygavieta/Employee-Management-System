package com.ems.Employee.Management.System.service.role;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Role;

import java.math.BigInteger;
import java.util.List;

public interface RoleService {
    Role findByRole(String role);

    List<Role> findAll();
    Role addRole(Role role);
}
