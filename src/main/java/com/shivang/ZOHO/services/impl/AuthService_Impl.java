package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.DTOs.requestDTOs.loginRequest;
import com.shivang.ZOHO.DTOs.requestDTOs.signUpRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.employeeDetailResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.models.Employees;
import com.shivang.ZOHO.models.Roles;
import com.shivang.ZOHO.models.Users;
import com.shivang.ZOHO.repositories.AuthRepo;
import com.shivang.ZOHO.services.authService;
import com.shivang.ZOHO.services.employeeService;
import com.shivang.ZOHO.services.roleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@Service
@NoArgsConstructor
public class AuthService_Impl implements authService {
    private AuthRepo authRepo;
    private roleService roleService;
    private employeeService employeeService;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public AuthService_Impl(AuthRepo authRepo, roleService roleService, employeeService employeeService){
        this.authRepo = authRepo;
        this.roleService = roleService;
        this.employeeService = employeeService;
    }
    @Override
    public loginResponse login(loginRequest request){
        Users user = authRepo.findByEmail(request.getEmail());
        if(user != null){
            boolean isCorrect = request.getPassword().matches(user.getPassword());
            employeeDetailResponse empResponse = employeeService.getEmpByUID(user.getId());
            loginResponse response = new loginResponse(user.getId(), empResponse.getFirst_name(), empResponse.getLast_name(), user.getEmail(), user.getRole().getRole_name(), user.is_active(), user.getCreated_date(), user.getUpdated_date());
            System.out.println(user);
            return response;
        }
        return null;
    }

    @Override
    public signUpResponse signup (signUpRequest request){
        Users newUser = new Users();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.set_active(true);
        newUser.setCreated_date(new Date());
        newUser.setUpdated_date(new Date());
        Roles role = roleService.findById(UUID.fromString(request.getRole_id()));
        newUser.setRole(role);
        Users createdUser = authRepo.save(newUser);
        Employees newEmployee = new Employees();
        newEmployee.setFirst_name(request.getFirst_name());
        newEmployee.setLast_name(request.getLast_name());
        newEmployee.setGender(request.getGender());
        newEmployee.setPhone("");
        newEmployee.setDesignation("");
        LocalDate localDate_dob = LocalDate.parse(request.getDob(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Date dob = Date.from(localDate_dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
        newEmployee.setDob(dob);
        newEmployee.setJoining_date(new Date());
        newEmployee.setUser(createdUser);
        employeeService.createEmployee(newEmployee);
        return new signUpResponse(createdUser.getId(), UUID.fromString(request.getRole_id()), createdUser.getEmail(), newEmployee.getFirst_name(), newEmployee.getLast_name(), newEmployee.getGender(), newEmployee.getPhone(), newEmployee.getDesignation(), newEmployee.getDob(), newEmployee.getJoining_date(), createdUser.getCreated_date(), createdUser.getUpdated_date());
    }
}
