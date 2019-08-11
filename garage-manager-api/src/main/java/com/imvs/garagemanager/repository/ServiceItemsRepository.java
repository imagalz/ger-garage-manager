package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.ServiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface ServiceItemsRepository extends JpaRepository<ServiceItems, Long> {

    List<ServiceItems> findAll();

    Optional<ServiceItems> findById(Long id);
    
}
