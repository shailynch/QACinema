package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Booking> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newBookingForm(@RequestBody Booking booking) {
		Booking newBooking = booking;
		service.addBooking(newBooking);
		return booking.toString();
	}

	@GetMapping("/{id}")
	Booking one(@PathVariable Long id) {

		return service.readBooking(id);
//      .orElseThrow(() -> new BookingNotFoundException(id));
	}

//	@PutMapping("/bookings/{id}")
//	Booking replaceBooking(@RequestBody Booking newBooking, @PathVariable Long id) {
//
//		return service.readBooking(id).map(booking -> {
//			booking.setFirstName(newBooking.getFirstName());
//			booking.setLastName(newBooking.getLastName());
//			booking.setEmail(newBooking.getEmail());
//
//			return repository.save(booking);
//		}).orElseGet(() -> {
//			newBooking.setId(id);
//			return repository.save(newBooking);
//		});
//	}

	@DeleteMapping("/{id}")
	void deleteBooking(@PathVariable Long id) {
		service.deleteByBookingID(id);
	}
}