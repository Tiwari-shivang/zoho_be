package com.shivang.ZOHO.DTOs.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignShiftRequest {
    private String empId;
    private String startTime, endTime;
}
