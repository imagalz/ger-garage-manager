package com.imvs.garagemanager.model;


import javax.persistence.*;

@Entity
@Table(name = "SERVICE_ITEMS")
public class ServiceItems {

    public ServiceItems() {
    }

    public ServiceItems(Long id, ServiceModel service_id, VehicleItems item_id) {
        this.id = id;
        this.service_id = service_id;
        this.item_id = item_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private ServiceModel service_id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private VehicleItems item_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceModel getService_id() {
        return service_id;
    }

    public void setService_id(ServiceModel service_id) {
        this.service_id = service_id;
    }

    public VehicleItems getItem_id() {
        return item_id;
    }

    public void setItem_id(VehicleItems item_id) {
        this.item_id = item_id;
    }
}

