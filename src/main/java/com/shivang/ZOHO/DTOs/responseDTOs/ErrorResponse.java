package com.shivang.ZOHO.DTOs.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private String message;
}
