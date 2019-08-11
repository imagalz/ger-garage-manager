package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.VehicleItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Component
public interface VehicleItemsRepository extends JpaRepository<VehicleItems, Long> {

    List<VehicleItems> findAll();

    Optional<VehicleItems> findById(Long id);
    
}
