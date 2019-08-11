package com.imvs.garagemanager.service;

import com.imvs.garagemanager.model.*;
import com.imvs.garagemanager.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CommonService {


    private VehicleRepository vehicleRepository;


    private VehicleMakeRepository vehicleMakeRepository;


    private VehicleTypeRepository vehicleTypeRepository;


    private VehicleItemsRepository vehicleItemsRepository;


    private ServiceTypeRepository serviceTypeRepository;


    private ServiceRepository serviceRepository;


    private EngineTypeRepository engineTypeRepository;


    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    public Optional<VehicleMake> getVehicleMakeById(Long id) {
        return vehicleMakeRepository.findById(id);
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> getVehicleTypeById(Long id) {
        return vehicleTypeRepository.findById(id);
    }


    public List<EngineType> getEngineTypes() {
        return engineTypeRepository.findAll();
    }

    public Optional<EngineType> getEngineTypeById(Long id) {
        return engineTypeRepository.findById(id);
    }

    
    public List<VehicleItems> getVehicleItems() {
        return vehicleItemsRepository.findAll();
    }

    public Optional<VehicleItems> getVehicleItemById(Long id) {
        return vehicleItemsRepository.findById(id);
    }



    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypeRepository.findAll();
    }

    public Optional<ServiceType> getServiceTypeById(Long id) {
        return serviceTypeRepository.findById(id);
    }


}
