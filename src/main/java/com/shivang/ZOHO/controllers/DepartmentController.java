package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.responseDTOs.ErrorResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.SuccessResponse;
import com.shivang.ZOHO.models.Departments;
import com.shivang.ZOHO.services.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private departmentService service;

    @PostMapping("")
    public ResponseEntity<Departments> createDepartment(@RequestBody Departments department){
        Departments newDepartment = service.createDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @GetMapping("")
    public ResponseEntity<?> getDepartments(@RequestParam String id){
        if(id.isEmpty()){
            return ResponseEntity.ok(service.getDepartments());
        }
        return ResponseEntity.ok(service.getDetailsDepartment(id));
    }

    @PutMapping("")
    public ResponseEntity<?> updateDepartment(@RequestBody Departments departments){
        if(departments.getId() == null){
            ErrorResponse error = new ErrorResponse(400, "Please provide correct department.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        return ResponseEntity.ok(service.updateDepartment(departments));
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteDepartment(@RequestParam String id){
        if(id.isEmpty()){
            ErrorResponse error = new ErrorResponse(400, "Please provide department id to delete.");
            return ResponseEntity.status(400).body(error);
        }
        service.deleteDepartment(id);
        SuccessResponse success = new SuccessResponse("Successfully delete department with id: " + id);
        return ResponseEntity.ok(success);
    }
}
