package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.DTOs.responseDTOs.employeeDetailResponse;
import com.shivang.ZOHO.models.Employees;
import com.shivang.ZOHO.repositories.EmployeeRepo;
import com.shivang.ZOHO.services.employeeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class EmployeeService_Impl implements employeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService_Impl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public void createEmployee(Employees employee){
        employeeRepo.save(employee);
    }

    @Override
    public employeeDetailResponse getEmpByUID(UUID userId){
        Employees employee = employeeRepo.findByUserId(userId).orElseThrow(() -> new RuntimeException(("No employee found with this user id")));
        employeeDetailResponse response = new employeeDetailResponse(employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getGender(), employee.getPhone(), employee.getDesignation(), employee.getDob(), employee.getJoining_date());
        return response;
    }
}
