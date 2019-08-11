package com.imvs.garagemanager.service;

import com.imvs.garagemanager.model.Booking;
import com.imvs.garagemanager.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class BookingService {

    private BookingRepository repository;

    public Booking createBooking(Booking booking) {
        return repository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return repository.update(booking);
    }

    public List<Booking> getBookings() {
        return repository.findAll();
    }

    public List<Booking> findAllBookingsByUser(Long userId) {
        return repository.findByUser_Id(userId);
    }

    public Optional<Booking> getBookingById(Long id) {
        return repository.findById(id);
    }


}
