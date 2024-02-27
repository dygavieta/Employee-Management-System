package com.ems.Employee.Management.System.service.role.impl;

import com.ems.Employee.Management.System.entity.Role;
import com.ems.Employee.Management.System.repository.RoleRepository;
import com.ems.Employee.Management.System.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleDBService implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
       return roleRepository.findByRole(role).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        if (roleRepository.findAll().stream().noneMatch(r -> role.getRole().equals(r.getRole()))){
            return roleRepository.save(role);
        }
        return null;
    }
}
