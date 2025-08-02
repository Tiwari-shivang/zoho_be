package com.shivang.ZOHO.DTOs.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class loginResponse {
    private UUID id;
    private String first_name, last_name, role_name, email;
    private boolean is_active;
    private Date created_at, update_at;
}
