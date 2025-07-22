package com.shivang.ZOHO.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "attendance")
public class Attendance implements Serializable {
    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employees employee;
    private Date date, check_in, check_out;
    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}