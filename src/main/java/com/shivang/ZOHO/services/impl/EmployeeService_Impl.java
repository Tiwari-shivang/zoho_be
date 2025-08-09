package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignDepartment;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeDetailResponse;
import com.shivang.ZOHO.models.Departments;
import com.shivang.ZOHO.models.Employees;
import com.shivang.ZOHO.repositories.EmployeeRepo;
import com.shivang.ZOHO.services.departmentService;
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
    private departmentService service;
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
        employeeDetailResponse response = new employeeDetailResponse(employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getGender(), employee.getPhone(), employee.getDesignation(), employee.getDepartment(), employee.getDob(), employee.getJoining_date());
        return response;
    }

    @Override
    public employeeDetailResponse assignDepartment(AssignDepartment department){
        Employees employees = employeeRepo.findById(UUID.fromString(department.getEmployee_id())).orElseThrow(() -> new RuntimeException("Employee not found"));
        if(employees != null){
            Departments departmentToAdd = service.getDetailsDepartment(department.getDepartment_id());
            employees.setDepartment(departmentToAdd);
            Employees updatedEmployee = employeeRepo.save(employees);
            return new employeeDetailResponse(updatedEmployee.getId(), updatedEmployee.getFirst_name(), updatedEmployee.getLast_name(), updatedEmployee.getGender(), updatedEmployee.getPhone(), updatedEmployee.getDesignation(), updatedEmployee.getDepartment(), updatedEmployee.getDob(), updatedEmployee.getJoining_date());
        }
        return null;
    }
}
