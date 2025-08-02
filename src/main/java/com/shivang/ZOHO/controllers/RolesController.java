package com.shivang.ZOHO.controllers;
import com.shivang.ZOHO.DTOs.responseDTOs.roleDetailResponse;
import com.shivang.ZOHO.models.Roles;
import com.shivang.ZOHO.services.roleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
@NoArgsConstructor
public class RolesController {
    private roleService roleService;

    @Autowired
    public RolesController(roleService roleService){
        this.roleService = roleService;
    }
    @GetMapping("")
    ResponseEntity<?> getAllRoles(@RequestParam String id){
        if(!id.isEmpty()){
            UUID role_id = UUID.fromString(id);
            Roles roles = roleService.findById(role_id);
            roleDetailResponse roleDetailResponse = new roleDetailResponse();
            roleDetailResponse.setRole_name(roles.getRole_name());
            roleDetailResponse.setId(roles.getId());
            roleDetailResponse.setDescription(roles.getDescription());
            return ResponseEntity.ok(roleDetailResponse);
        }
        return ResponseEntity.ok("sd");
    }
}
