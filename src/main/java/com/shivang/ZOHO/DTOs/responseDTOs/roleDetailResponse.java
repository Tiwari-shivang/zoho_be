package com.shivang.ZOHO.DTOs.responseDTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class roleDetailResponse {
    private UUID id;
    private String role_name, description;
}
