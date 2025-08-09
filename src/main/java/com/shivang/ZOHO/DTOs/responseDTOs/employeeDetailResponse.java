package com.shivang.ZOHO.DTOs.responseDTOs;

import com.shivang.ZOHO.models.Departments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class employeeDetailResponse {
    private UUID id;
    private String first_name, last_name, gender, phone, designation;
    private Departments department;
    private Date dob, joining_date;
}
