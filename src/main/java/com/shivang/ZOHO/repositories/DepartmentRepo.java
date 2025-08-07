package com.shivang.ZOHO.repositories;

import com.shivang.ZOHO.models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<Departments, UUID> {
}
