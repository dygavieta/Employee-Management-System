package com.ems.Employee.Management.System.controller;

import com.ems.Employee.Management.System.dto.EmployeeDTO;
import com.ems.Employee.Management.System.dto.EmployeeResponse;
import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.entity.Employee;
import com.ems.Employee.Management.System.entity.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.ems.Employee.Management.System.service.employee.EmployeeService;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable("employeeId")BigInteger employeeId){
        final EmployeeDTO employee = employeeService.findById(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping()
    public ResponseEntity<Employee> findByFullName(@RequestParam(name = "fullName") String fullName){
        final Employee employee = employeeService.findByFullName(fullName);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @GetMapping(path = "/all/page")
    public ResponseEntity<Page<Employee>> findByPage(@RequestParam int page, @RequestParam int items, @RequestParam(required = false) boolean sorted){
        return ResponseEntity.ok().body(employeeService.findByPage(page,items, sorted));
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody EmployeeResponse employee){
        return ResponseEntity.ok().body(employeeService.addEmployee(employee));
    }

    @PutMapping(path = "/{employeeId}/emergency-contact")
    public ResponseEntity<Employee>  addEmergencyContact(@PathVariable("employeeId") BigInteger employeeId, @RequestBody EmergencyContact emergencyContact) {
        return ResponseEntity.ok().body(employeeService.addEmergencyContact(employeeId,emergencyContact));
    }

//    @PutMapping("/{employeeId}/role")
//    public ResponseEntity<Employee>  addRole(@PathVariable("employeeId") BigInteger employeeId, @RequestBody Role role) {
//        return ResponseEntity.ok().body(employeeService.addRole(employeeId,emergencyContact));
//    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Employee> deleteById(@PathVariable("employeeId")BigInteger employeeId){
        return ResponseEntity.ok().body(employeeService.deleteById(employeeId));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Employee>> findByCreatedDateBetween(@RequestParam(name = "start") LocalDate start, @RequestParam(name = "end") LocalDate end){
        System.out.println("HELLOOO: " + start.getClass());
        return ResponseEntity.ok().body(employeeService.findByCreatedDateBetween(start,end));
    }




    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
