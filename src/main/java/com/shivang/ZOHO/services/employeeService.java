package com.shivang.ZOHO.services;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignDepartment;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeDetailResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeUserDetails;
import com.shivang.ZOHO.models.Employees;

import java.util.List;
import java.util.UUID;

public interface employeeService {
    void createEmployee(Employees employee);
    employeeDetailResponse getEmpByUID(UUID userId);
    employeeUserDetails getEmpById(UUID id);
    List<employeeUserDetails> getEmployees(String searchedVal, Integer limit);
    employeeDetailResponse assignDepartment(AssignDepartment department);
}
