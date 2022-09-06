package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.Booking;
import com.qa.cinema.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private final BookingService service;

	@Autowired
	BookingController(BookingService service) {
		this.service = service;
	}

	@CrossOrigin
	@GetMapping("/all")
	public List<Booking> getAllBookings() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Booking> newBookingForm(@RequestBody Booking booking) {
		Booking createBooking = service.addBooking(booking);
		return new ResponseEntity<Booking>(createBooking, HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Booking readBookingById(@PathVariable Long id) {

		return service.readBooking(id);
	}

	@CrossOrigin
	@PutMapping("/bookings/{id}")
	public ResponseEntity<Booking> updateBookingById(@PathVariable("bookingId") Long Id, @RequestBody Booking booking) {
		Booking updateBooking = this.service.updateBooking(booking, Id);
		return new ResponseEntity<Booking>(updateBooking, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteByBookingID(id), HttpStatus.NO_CONTENT);
	}
}