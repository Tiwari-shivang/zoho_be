package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.requestDTOs.AssignShiftRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.SuccessResponse;
import com.shivang.ZOHO.services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminControllers {
    @Autowired
    private adminService adminService;

    @PostMapping("/assign-shift")
    ResponseEntity<?> assignShift (@RequestBody AssignShiftRequest shiftRequest){
        adminService.assignShift(shiftRequest);
        SuccessResponse response = new SuccessResponse("Shift assigned successfully");
        return ResponseEntity.ok(response);
    }
}
