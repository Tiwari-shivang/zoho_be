package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignDepartment;
import com.shivang.ZOHO.DTOs.responseDTOs.ErrorResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeUserDetails;
import com.shivang.ZOHO.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private employeeService service;
    @GetMapping("")
    public ResponseEntity<?> getEmployees(@RequestParam (required = false) String id, @RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "") String searchedValue){
        if(id != null){
            employeeUserDetails empDetails = service.getEmpById(UUID.fromString(id));
            if(empDetails != null){
                return ResponseEntity.ok(empDetails);
            }
            ErrorResponse error = new ErrorResponse(404, "Employee with id: " + id + " not found.");
            return ResponseEntity.status(404).body(error);
        }
        return ResponseEntity.ok(service.getEmployees(searchedValue, limit));
    }
    @PostMapping("/add-department")
    public ResponseEntity<?> addDepartment(@RequestBody AssignDepartment department){
        if(department.getDepartment_id().isEmpty() || department.getEmployee_id().isEmpty()){
            ErrorResponse error = new ErrorResponse(400, "Please provide both department and employee id");
            return ResponseEntity.status(400).body(error);
        }
        return ResponseEntity.ok(service.assignDepartment(department));
    }
}
