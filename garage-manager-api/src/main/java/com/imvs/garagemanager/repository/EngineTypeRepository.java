package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.EngineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Component
public interface EngineTypeRepository extends JpaRepository<EngineType, Long> {

    List<EngineType> findAll();

    Optional<EngineType> findById(Long id);

}
