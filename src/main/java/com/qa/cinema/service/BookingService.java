package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cinema.models.Booking;
import com.qa.cinema.repo.BookingRepo;

@Service
public class BookingService {

	@Autowired
	private BookingRepo repo;

	@Autowired
	public BookingService(BookingRepo repo) {
		this.repo = repo;
	}

	// create
	public Booking addBooking(Booking newBooking) {
		return repo.save(newBooking);
	}

	// read
	public Booking readBooking(Long id) {
		return repo.findById(id).get();
		// .get returns null or the booking as the booking would be optional
		// type check would be better
	}

	public List<Booking> readAll() {
		return repo.allFromBooking();
		// .get returns null or the booking as the booking would be optional
		// type check would be better
	}

	// update - change to current booking and new booking
	public Booking updateBooking(Booking updateBooking, Long id) {
		Optional<Booking> currentBooking = this.repo.findById(id);
		if (currentBooking.get() instanceof Booking) {
			Booking oldBooking = currentBooking.get();
			oldBooking.setCustomerID(updateBooking.getCustomerID());
			oldBooking.setViewingID(updateBooking.getViewingID());
			oldBooking.setBookingDate(updateBooking.getBookingDate());

			return repo.save(oldBooking);
		}
		return null;

	}

	// delete
	public boolean deleteByBookingID(Long id) {
		Optional<Booking> currentBooking = this.repo.findById(id);
		boolean isPresent = (currentBooking.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
