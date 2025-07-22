package com.shivang.ZOHO.repositories;

import com.shivang.ZOHO.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface userRepo extends JpaRepository<Users, UUID> {
}
