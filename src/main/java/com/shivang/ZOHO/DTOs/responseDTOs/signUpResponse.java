package com.shivang.ZOHO.DTOs.responseDTOs;

import com.shivang.ZOHO.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class signUpResponse {
    private UUID id, role_id;
    private String email, first_name, last_name, gender, phone, designation;
    private Date dob, joining_date, created_at, updated_at;
}