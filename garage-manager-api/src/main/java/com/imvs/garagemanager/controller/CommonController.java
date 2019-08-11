package com.imvs.garagemanager.controller;

import com.imvs.garagemanager.controller.request.LoginRequest;
import com.imvs.garagemanager.model.*;
import com.imvs.garagemanager.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService service;

    @GetMapping("/user/{userId}")
    public ResponseEntity<VehicleMake> getVehicleMakeById(@PathVariable("vehicleMakeId") Long vehicleMakeId) {
        
        Optional<VehicleMake> response = service.getVehicleMakeById(vehicleMakeId);

        return new ResponseEntity<VehicleMake>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/vehicleType/{vehicleTypeId}")
    public ResponseEntity<VehicleType> getVehicleTypeById(@PathVariable("vehicleTypeId") Long vehicleTypeId) {
        
        Optional<VehicleType> response =service.getVehicleTypeById(vehicleTypeId);

        return new ResponseEntity<VehicleType>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        
        Optional<Vehicle> response = service.getVehicleById(vehicleId);

        return new ResponseEntity<Vehicle>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/engineType/{engineId}")
    public ResponseEntity<EngineType> getEngineById(@PathVariable("engineId") Long engineId) {
        
        Optional<EngineType> response = service.getEngineTypeById(engineId);

        return new ResponseEntity<EngineType>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/engineTypes")
    private ResponseEntity<List<EngineType>> getEngineTypes() {
        
        List<EngineType> response = service.getEngineTypes();

        return new ResponseEntity<List<EngineType>>(response, HttpStatus.OK);
    }

    @GetMapping("/vehicleMakes")
    private ResponseEntity<List<VehicleMake>> getVehicleMakes() {
        
        List<VehicleMake> response = service.getVehicleMakes();

        return new ResponseEntity<List<VehicleMake>>(response, HttpStatus.OK);
    }

    @GetMapping("/vehicleTypes")
    private ResponseEntity<List<VehicleType>> getVehicleTypes() {
        
        List<VehicleType> response = service.getVehicleTypes();

        return new ResponseEntity<List<VehicleType>>(response, HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    private ResponseEntity<List<Vehicle>> getVehicle() {
        
        List<Vehicle> response = service.getVehicles();

        return new ResponseEntity<List<Vehicle>>(response, HttpStatus.OK);
    }

    @GetMapping("/serviceTypes")
    private ResponseEntity<List<ServiceType>> getServiceTypes() {
        
        List<ServiceType> response = service.getServiceTypes();

        return new ResponseEntity<List<ServiceType>>(response, HttpStatus.OK);
    }

    @GetMapping("/service/{serviceTypeId}")
    public ResponseEntity<ServiceType> getServiceTypeById(@PathVariable("serviceTypeId") Long serviceTypeId) {
        Optional<ServiceType> response =service.getServiceTypeById(serviceTypeId);

        return new ResponseEntity<ServiceType>(response.get(), HttpStatus.OK);
    }
    
}
