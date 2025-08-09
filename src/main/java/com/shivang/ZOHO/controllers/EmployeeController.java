package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignDepartment;
import com.shivang.ZOHO.DTOs.responseDTOs.ErrorResponse;
import com.shivang.ZOHO.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private employeeService service;
    @PostMapping("/add-department")
    public ResponseEntity<?> addDepartment(@RequestBody AssignDepartment department){
        if(department.getDepartment_id().isEmpty() || department.getEmployee_id().isEmpty()){
            ErrorResponse error = new ErrorResponse(400, "Please provide both department and employee id");
            return ResponseEntity.status(400).body(error);
        }
        return ResponseEntity.ok(service.assignDepartment(department));
    }
}
