package com.imvs.garagemanager.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SERVICE")
public class ServiceModel {

    public ServiceModel() {
    }

    public ServiceModel(User employee_id, ServiceType service_type_id, LocalDateTime started_date, LocalDateTime estimated_date, LocalDateTime finished_date, String reason_ext_time, BigDecimal cost, String status) {
        this.employee_id = employee_id;
        this.service_type_id = service_type_id;
        this.started_date = started_date;
        this.estimated_date = estimated_date;
        this.finished_date = finished_date;
        this.reason_ext_time = reason_ext_time;
        this.cost = cost;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private User employee_id;

    @ManyToOne
    @JoinColumn(name = "SERVICE_TYPE_ID", nullable = false)
    private ServiceType service_type_id;

    @Column(name = "STARTED_DATE", nullable = false)
    private LocalDateTime started_date;

    @Column(name = "ESTIMATED_DATE", nullable = false)
    private LocalDateTime estimated_date;

    @Column(name = "FINISHED_DATE")
    private LocalDateTime finished_date;

    @Column(name = "REASON_EXT_TIME")
    private String reason_ext_time;

    @Column(name = "COST")
    private BigDecimal cost;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(User employee_id) {
        this.employee_id = employee_id;
    }

    public ServiceType getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(ServiceType service_type_id) {
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

