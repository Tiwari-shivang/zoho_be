package com.shivang.ZOHO.DTOs.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AssignDepartment {
    private String department_id, employee_id;
}
