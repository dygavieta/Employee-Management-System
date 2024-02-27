package com.ems.Employee.Management.System.controller;

import com.ems.Employee.Management.System.entity.Role;
import com.ems.Employee.Management.System.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
       return ResponseEntity.ok().body(roleService.findAll());
    }

    @PostMapping
    public  ResponseEntity<Role> addRole(@RequestBody Role role){
        return ResponseEntity.ok().body(roleService.addRole(role));
    }
}
