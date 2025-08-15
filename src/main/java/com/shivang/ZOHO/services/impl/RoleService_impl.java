package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.DTOs.requestDTOs.CreateRole;
import com.shivang.ZOHO.models.Roles;
import com.shivang.ZOHO.repositories.RoleRepo;
import com.shivang.ZOHO.services.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService_impl implements roleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleService_impl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }
    @Override
    public Roles findById(UUID id){
        return roleRepo.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public List<Roles> findAll(){
        return roleRepo.findAll();
    }

    @Override
    public Roles createRole(CreateRole req){
        Roles createdRole = new Roles();
        createdRole.setRole_name(req.getRole_name());
        createdRole.setDescription(req.getDescription());
        return roleRepo.save(createdRole);
    }
}
