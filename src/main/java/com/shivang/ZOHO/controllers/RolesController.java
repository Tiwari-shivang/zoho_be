package com.shivang.ZOHO.controllers;
import com.shivang.ZOHO.DTOs.requestDTOs.CreateRole;
import com.shivang.ZOHO.DTOs.responseDTOs.ErrorResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.RolesListResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.roleDetailResponse;
import com.shivang.ZOHO.models.Roles;
import com.shivang.ZOHO.services.roleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/public/roles")
@NoArgsConstructor
public class RolesController {
    private roleService roleService;

    @Autowired
    public RolesController(roleService roleService){
        this.roleService = roleService;
    }
    @GetMapping("")
    ResponseEntity<?> getAllRoles(@RequestParam String id){
        try{
            if(!id.isEmpty()){
                UUID role_id = UUID.fromString(id);
                Roles roles = roleService.findById(role_id);
                roleDetailResponse roleDetailResponse = new roleDetailResponse();
                roleDetailResponse.setRole_name(roles.getRole_name());
                roleDetailResponse.setId(roles.getId());
                roleDetailResponse.setDescription(roles.getDescription());
                return ResponseEntity.ok(roleDetailResponse);
            }
            RolesListResponse listResponse = new RolesListResponse();
            listResponse.setRoles(roleService.findAll());
            return ResponseEntity.ok(listResponse);
        }
        catch (Exception e){
            ErrorResponse error = new ErrorResponse(500, e.getMessage());
            return ResponseEntity.status(error.getStatus()).body(error);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody CreateRole role){
        return ResponseEntity.ok(roleService.createRole(role));
    }
}
