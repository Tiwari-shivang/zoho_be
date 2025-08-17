package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignShiftRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeUserDetails;
import com.shivang.ZOHO.models.Employees;
import com.shivang.ZOHO.models.Users;
import com.shivang.ZOHO.repositories.userRepo;
import com.shivang.ZOHO.services.adminService;
import com.shivang.ZOHO.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.UUID;

@Service
public class AdminService_Impl implements adminService {
    @Autowired
    private employeeService employeeService;
    @Autowired
    private userRepo userRepo;

    @Override
    public void assignShift(AssignShiftRequest shiftRequest){
        employeeUserDetails employee = employeeService.getEmpById(UUID.fromString(shiftRequest.getEmpId()));
        if(employee != null){
            LocalTime start_shift = LocalTime.parse(shiftRequest.getStartTime());
            LocalTime end_shift = LocalTime.parse(shiftRequest.getEndTime());
            Users user = userRepo.getById(employee.getUid());
            Employees updatedEmployee = new Employees(employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getGender(), employee.getPhone(), employee.getDesignation(), employee.getDob(), employee.getJoining_date(), start_shift, end_shift, user, employee.getDepartment());
            employeeService.createEmployee(updatedEmployee);
        }
    }
}
