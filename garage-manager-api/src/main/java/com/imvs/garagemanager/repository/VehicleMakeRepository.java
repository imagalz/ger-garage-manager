package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Long> {

    List<VehicleMake> findAll();

    Optional<VehicleMake> findById(Long id);
    
}
