package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {

    List<ServiceModel> findByEmployee_Id(Long employeeId);

    List<ServiceModel> findAll();

    Optional<ServiceModel> findById(Long id);

    ServiceModel save(ServiceModel booking);

    ServiceModel update(ServiceModel booking);
    
}
