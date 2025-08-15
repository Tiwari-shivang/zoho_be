package com.shivang.ZOHO.DTOs.responseDTOs;

import com.shivang.ZOHO.models.Departments;
import com.shivang.ZOHO.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeUserDetails {
    private UUID id, uid;
    private boolean is_active;
    private String first_name, last_name, gender, phone, designation, email;
    private Departments department;
    private Date dob, joining_date;
}
