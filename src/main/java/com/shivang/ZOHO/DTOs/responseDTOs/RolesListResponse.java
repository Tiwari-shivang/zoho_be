package com.shivang.ZOHO.DTOs.responseDTOs;

import com.shivang.ZOHO.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolesListResponse {
    private List<Roles> roles;
}
