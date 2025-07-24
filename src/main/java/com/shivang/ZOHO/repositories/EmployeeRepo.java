package com.shivang.ZOHO.repositories;

import com.shivang.ZOHO.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employees, UUID> {
    Optional<Employees> findByUserId(UUID userId);
}
