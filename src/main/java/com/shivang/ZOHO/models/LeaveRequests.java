package com.shivang.ZOHO.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "leave_requests")
public class LeaveRequests implements Serializable {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employees employee;
    private String leave_type, reason, status;
    private Date from_date, to_date, requested_at;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLeave_type() {
        return leave_type;
    }

    public void setLeave_type(String leave_type) {
        this.leave_type = leave_type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public Date getRequested_at() {
        return requested_at;
    }

    public void setRequested_at(Date requested_at) {
        this.requested_at = requested_at;
    }
}
