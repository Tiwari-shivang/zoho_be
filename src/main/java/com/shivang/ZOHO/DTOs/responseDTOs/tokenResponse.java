package com.shivang.ZOHO.DTOs.responseDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class tokenResponse {
    private loginResponse user;
    private String token;
}
