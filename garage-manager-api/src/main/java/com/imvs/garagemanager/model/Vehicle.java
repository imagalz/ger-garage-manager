package com.imvs.garagemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle  {

    public Vehicle() {
    }

    public Vehicle(Long id, VehicleType type_id, EngineType engine_id, String license, Long year) {
        this.id = id;
        this.type_id = type_id;
        this.engine_id = engine_id;
        this.license = license;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = false)
    private VehicleType type_id;
    
    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", nullable = false)
    private EngineType engine_id;

    @Column(name = "LICENSE", nullable = false)
    private String license;

    @Column(name = "YEAR", nullable = false)
    private Long year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getType_id() {
        return type_id;
    }

    public void setType_id(VehicleType type_id) {
        this.type_id = type_id;
    }

    public EngineType getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(EngineType engine_id) {
        this.engine_id = engine_id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}

