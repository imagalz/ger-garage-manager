package com.imvs.garagemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOOKING")
public class Booking {

    public Booking() {
    }

    public Booking(Long id, User customer_id, ServiceModel service_id, Vehicle vehicle_id,
                   LocalDateTime booking_date, LocalDateTime estimated_date, LocalDateTime finished_date,
                   String reason_ext_time, String observation) {
        this.id = id;
        this.customer_id = customer_id;
        this.service_id = service_id;
        this.vehicle_id = vehicle_id;
        this.booking_date = booking_date;
        this.estimated_date = estimated_date;
        this.finished_date = finished_date;
        this.reason_ext_time = reason_ext_time;
        this.observation = observation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private User customer_id;
    
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private ServiceModel service_id;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    private Vehicle vehicle_id;

    @Column(name = "BOOKING_DATE", nullable = false)
    private LocalDateTime booking_date;

    @Column(name = "ESTIMATED_DATE", nullable = false)
    private LocalDateTime estimated_date;

    @Column(name = "FINISHED_DATE")
    private LocalDateTime finished_date;

    @Column(name = "REASON_EXT_TIME")
    private String reason_ext_time;

    @Column(name = "OBSERVATION")
    private String observation;


    /**
     * GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(User customer_id) {
        this.customer_id = customer_id;
    }

    public ServiceModel getService_id() {
        return service_id;
    }

    public void setService_id(ServiceModel service_id) {
        this.service_id = service_id;
    }

    public Vehicle getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Vehicle vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDateTime booking_date) {
        this.booking_date = booking_date;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}

