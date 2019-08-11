package com.imvs.garagemanager.controller;

import com.imvs.garagemanager.model.ServiceModel;
import com.imvs.garagemanager.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/register")
    public ResponseEntity<ServiceModel> registerService(@RequestBody ServiceModel service) {
        ServiceModel response = serviceService.createService(service);

        return new ResponseEntity<ServiceModel>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceModel> updateService(@RequestBody ServiceModel service) {
        ServiceModel response = serviceService.updateService(service);

        return new ResponseEntity<ServiceModel>(response, HttpStatus.OK);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceModel> getServiceById(@PathVariable("serviceId") Long serviceId) {
        // TODO: put a try/catch
        Optional<ServiceModel> response = serviceService.getServiceById(serviceId);

        return new ResponseEntity<ServiceModel>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<ServiceModel>> getServiceByEmployee(@PathVariable("employeeId") Long employeeId) {
        List<ServiceModel> response = serviceService.findAllServicesByEmployee(employeeId);

        return new ResponseEntity<List<ServiceModel>>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<ServiceModel>> getAllServices() {
        List<ServiceModel> response = serviceService.getServices();

        return new ResponseEntity<List<ServiceModel>>(response, HttpStatus.OK);
    }
    
}
