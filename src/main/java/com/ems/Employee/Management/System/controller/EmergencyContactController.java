package com.ems.Employee.Management.System.controller;

import com.ems.Employee.Management.System.entity.EmergencyContact;
import com.ems.Employee.Management.System.service.emergencyContact.EmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RequestMapping("/emergency-contact")
@RequiredArgsConstructor
@Controller
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    @GetMapping
    public ResponseEntity<EmergencyContact> findByContactNumber(@RequestParam(name = "contactNumber") String contactNumber){
        return ResponseEntity.ok().body(emergencyContactService.findByContactNumber(contactNumber));
    }
}
