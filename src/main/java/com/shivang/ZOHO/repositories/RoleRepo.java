package com.shivang.ZOHO.repositories;

import com.shivang.ZOHO.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepo extends JpaRepository<Roles, UUID> {
}
