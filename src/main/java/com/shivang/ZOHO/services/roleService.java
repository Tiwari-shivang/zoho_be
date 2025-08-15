package com.shivang.ZOHO.services;

import com.shivang.ZOHO.DTOs.requestDTOs.CreateRole;
import com.shivang.ZOHO.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface roleService {
    Roles findById(UUID id);
    List<Roles> findAll();
    Roles createRole(CreateRole role);
}
