package com.ems.Employee.Management.System.controller;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ems.Employee.Management.System.service.employee.EmployeeService;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable("employeeId")BigInteger employeeId){
        final Employee employee = employeeService.findById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping()
    public ResponseEntity<Employee> findByFullName(@RequestParam(name = "fullName") String fullName){
        final Employee employee = employeeService.findByFullName(fullName);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.addEmployee(employee));
    }

    @PutMapping("/{employeeId}/emergency-contact")
    public ResponseEntity<Employee>  addEmergencyContact(@PathVariable("employeeId") BigInteger employeeId, @RequestBody EmergencyContact emergencyContact) {
        return ResponseEntity.ok().body(employeeService.addEmergencyContact(employeeId,emergencyContact));
    }

//    @PutMapping("/{employeeId}/role")
//    public ResponseEntity<Employee>  addRole(@PathVariable("employeeId") BigInteger employeeId, @RequestBody Role role) {
//        return ResponseEntity.ok().body(employeeService.addRole(employeeId,emergencyContact));
//    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteById(@PathVariable("employeeId")BigInteger employeeId){
        return ResponseEntity.ok().body(employeeService.deleteById(employeeId));
    }
}
