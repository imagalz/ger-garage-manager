package com.imvs.garagemanager.service;

import com.imvs.garagemanager.model.ServiceModel;
import com.imvs.garagemanager.model.User;
import com.imvs.garagemanager.repository.ServiceRepository;
import com.imvs.garagemanager.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

;

@Service
@Component
public class ServiceService {


    private ServiceRepository repository;


    private UserRepository userRepository;

    public ServiceModel createService(ServiceModel serviceRequest) {
        Optional<User> employee = userRepository.findById(serviceRequest.getId());
        List<ServiceModel> serviceList = repository.findByEmployee_Id(serviceRequest.getEmployee_id().getId());

        List<ServiceModel> serviceListByUser = new ArrayList<>();
        ServiceModel serviceReturn = new ServiceModel();

        boolean maximumPerEmployee = false;

        serviceList.forEach(service -> {
            if (employee.equals(service.getEmployee_id()) ) {
                serviceListByUser.add(service);
            }
        });

         // Not aloowed more than 4 services per day
        for (ServiceModel service : serviceListByUser) {
            int servicePerDay = 0;

            for (ServiceModel serviceModel: serviceListByUser){
                if (service.getStarted_date().equals(serviceModel.getStarted_date())){
                    servicePerDay ++;
                }
            }

            if ( servicePerDay > 4 ) {
                maximumPerEmployee = true;
                break;
            }
        }

        serviceReturn = maximumPerEmployee ?
                new ServiceModel(serviceRequest.getEmployee_id(), serviceRequest.getService_type_id(), serviceRequest.getStarted_date(),
                        serviceRequest.getEstimated_date(), serviceRequest.getFinished_date(),
                        serviceRequest.getReason_ext_time(), serviceRequest.getCost(), serviceRequest.getStatus()) :
                new ServiceModel();



        return repository.save(serviceReturn);
    }

    public ServiceModel updateService(ServiceModel service) {
        return repository.update(service);
    }

    public List<ServiceModel> getServices() {
        return repository.findAll();
    }

    public List<ServiceModel> findAllServicesByEmployee(Long employeeId) {
        return repository.findByEmployee_Id(employeeId);
    }

    public Optional<ServiceModel> getServiceById(Long id) {
        return repository.findById(id);
    }

}
