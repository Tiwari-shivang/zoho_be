package com.shivang.ZOHO.services;

import com.shivang.ZOHO.models.Departments;

import java.util.List;

public interface departmentService {
    Departments createDepartment(Departments department);
    Departments getDetailsDepartment(String id);
    List<Departments> getDepartments();
    Departments updateDepartment(Departments departments);
    void deleteDepartment(String id);
}
