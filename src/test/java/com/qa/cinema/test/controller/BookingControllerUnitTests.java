package com.qa.cinema.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.cinema.controllers.BookingController;
import com.qa.cinema.models.Booking;
import com.qa.cinema.repo.BookingRepo;
import com.qa.cinema.service.BookingService;

@SpringBootTest
public class BookingControllerUnitTests {

	@Autowired
	private BookingController controller;

	@MockBean
	private BookingService service;

	@MockBean
	private BookingRepo repo;

	@Test
	public void createNewBookingTest() {
		Booking validBooking = new Booking(1L, 1L, "01-09-22", 1L);
		Mockito.when(this.service.addBooking(validBooking)).thenReturn(validBooking);
		ResponseEntity<Booking> response = new ResponseEntity<Booking>(validBooking, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.newBookingForm(validBooking));
		Mockito.verify(this.service, Mockito.times(1)).addBooking(validBooking);
	}

	@Test
	public void getAllBookingsTest() {
		Booking validBooking = new Booking(1L, 1L, "01-09-22", 1L);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(validBooking);
		Mockito.when(this.service.readAll()).thenReturn(bookings);
		assertThat(bookings).isEqualTo(controller.getAllBookings());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void getBookingByIdTest() {
		Booking validBooking = new Booking(1L, 1L, "01-09-22", 1L);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(validBooking);

		Mockito.when(this.service.readBooking(validBooking.getId())).thenReturn(bookings.get(0));

		Booking value = bookings.get(0);

		assertThat(value).isEqualTo(controller.readBookingById(validBooking.getId()));

		Mockito.verify(this.service, Mockito.times(1)).readBooking(validBooking.getId());
	}

	@Test
	public void updateBookingById() {
		Booking validBooking = new Booking(1L, 1L, "01-09-22", 1L);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(validBooking);

		Booking updateBooking = new Booking(2L, "02-09-22", 2L);

		Mockito.when(this.service.updateBooking(updateBooking, validBooking.getId())).thenReturn(validBooking);
		ResponseEntity<Booking> response = new ResponseEntity<Booking>(validBooking, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateBookingById(validBooking.getId(), updateBooking));
		Mockito.verify(this.service, Mockito.times(1)).updateBooking(updateBooking, validBooking.getId());
	}

	@Test
	public void deleteBookingtest() {
		Booking validBooking = new Booking(1L, 1L, "01-09-22", 1L);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(validBooking);

		Mockito.when(this.service.deleteByBookingID(validBooking.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteBooking(validBooking.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByBookingID(validBooking.getId());

	}

}
