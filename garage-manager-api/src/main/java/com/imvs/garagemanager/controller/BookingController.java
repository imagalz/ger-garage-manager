package com.imvs.garagemanager.controller;

import com.imvs.garagemanager.model.Booking;
import com.imvs.garagemanager.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/register")
    public ResponseEntity<Booking> registerBooking(@RequestBody Booking booking) {
        Booking response = service.createBooking(booking);

        return new ResponseEntity<Booking>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        Booking response = service.updateBooking(booking);

        return new ResponseEntity<Booking>(response, HttpStatus.OK);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") Long bookingId) {
        Optional<Booking> response = service.getBookingById(bookingId);

        return new ResponseEntity<Booking>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUser(@PathVariable("userId") Long userId) {
        List<Booking> response =service.findAllBookingsByUser(userId);

        return new ResponseEntity<List<Booking>>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> response = service.getBookings();

        return new ResponseEntity<List<Booking>>(response, HttpStatus.OK);
    }
    
}
