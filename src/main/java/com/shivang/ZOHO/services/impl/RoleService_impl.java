package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.models.Roles;
import com.shivang.ZOHO.repositories.RoleRepo;
import com.shivang.ZOHO.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService_impl implements roleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleService_impl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }
    public Roles findById(UUID id){
        return roleRepo.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }
}
