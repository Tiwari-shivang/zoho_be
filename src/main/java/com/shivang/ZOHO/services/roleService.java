package com.shivang.ZOHO.services;

import com.shivang.ZOHO.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface roleService {
    Roles findById(UUID id);
}
