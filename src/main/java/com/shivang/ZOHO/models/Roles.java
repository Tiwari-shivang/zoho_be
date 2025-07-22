package com.shivang.ZOHO.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {
    @Id
    private UUID id;
    private String role_name, description;
}
