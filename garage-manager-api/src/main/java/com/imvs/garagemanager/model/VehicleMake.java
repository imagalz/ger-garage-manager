package com.imvs.garagemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_MAKE")
public class VehicleMake {

    public VehicleMake() {
    }

    public VehicleMake(Long id, String name, VehicleType type_id) {
        this.id = id;
        this.name = name;
        this.type_id = type_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = false)
    private VehicleType type_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getType_id() {
        return type_id;
    }

    public void setType_id(VehicleType type_id) {
        this.type_id = type_id;
    }

}

