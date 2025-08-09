package com.shivang.ZOHO.services;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignDepartment;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeDetailResponse;
import com.shivang.ZOHO.models.Employees;

import java.util.UUID;

public interface employeeService {
    void createEmployee(Employees employee);
    employeeDetailResponse getEmpByUID(UUID userId);
    employeeDetailResponse assignDepartment(AssignDepartment department);
}
