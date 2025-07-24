package com.shivang.ZOHO.DTOs.responseDTOs;

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
    private Date dob, joining_date;
}
