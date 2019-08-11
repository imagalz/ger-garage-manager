package com.imvs.garagemanager.controller.request;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceRequest {

    private Long id;
    private Long employee_id;
    private Long service_type_id;
    private LocalDateTime started_date;
    private LocalDateTime estimated_date;
    private LocalDateTime finished_date;
    private String reason_ext_time;
    private BigDecimal cost;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(Long service_type_id) {
        this.service_type_id = service_type_id;
    }

    public LocalDateTime getStarted_date() {
        return started_date;
    }

    public void setStarted_date(LocalDateTime started_date) {
        this.started_date = started_date;
    }

    public LocalDateTime getEstimated_date() {
        return estimated_date;
    }

    public void setEstimated_date(LocalDateTime estimated_date) {
        this.estimated_date = estimated_date;
    }

    public LocalDateTime getFinished_date() {
        return finished_date;
    }

    public void setFinished_date(LocalDateTime finished_date) {
        this.finished_date = finished_date;
    }

    public String getReason_ext_time() {
        return reason_ext_time;
    }

    public void setReason_ext_time(String reason_ext_time) {
        this.reason_ext_time = reason_ext_time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

