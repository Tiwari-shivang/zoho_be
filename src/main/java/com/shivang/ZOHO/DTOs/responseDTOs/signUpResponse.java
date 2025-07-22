package com.shivang.ZOHO.DTOs.responseDTOs;

import com.shivang.ZOHO.models.Users;

public class signUpResponse {
    private Users user;

    public signUpResponse(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
