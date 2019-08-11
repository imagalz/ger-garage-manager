package com.imvs.garagemanager.repository;

import com.imvs.garagemanager.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser_Id(Long userId);

    List<Booking> findAll();

    Optional<Booking> findById(Long id);

    Booking save(Booking booking);

    Booking update(Booking booking);
    
}
