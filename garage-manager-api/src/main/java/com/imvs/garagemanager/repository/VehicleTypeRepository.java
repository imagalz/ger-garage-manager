package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

    List<VehicleType> findAll();

    Optional<VehicleType> findById(Long id);

}
