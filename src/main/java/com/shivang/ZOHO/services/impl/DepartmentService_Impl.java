package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.models.Departments;
import com.shivang.ZOHO.repositories.DepartmentRepo;
import com.shivang.ZOHO.services.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService_Impl implements departmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public Departments createDepartment(Departments department){
        return departmentRepo.save(department);
    }

    @Override
    public Departments getDetailsDepartment(String id){
       return departmentRepo.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public List<Departments> getDepartments(){
        return departmentRepo.findAll();
    }

    @Override
    public Departments updateDepartment(Departments departments){
        Departments foundDepartment = departmentRepo.findById(departments.getId()).orElseThrow(() -> new RuntimeException("Department not found"));
        if(foundDepartment != null){
            return departmentRepo.save(departments);
        }
        return null;
    }

    @Override
    public void deleteDepartment(String id){
        Departments department = departmentRepo.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepo.delete(department);
    }
}
