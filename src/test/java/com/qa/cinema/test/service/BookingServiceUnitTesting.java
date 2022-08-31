package com.qa.cinema.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.cinema.models.Booking;
import com.qa.cinema.repo.BookingRepo;
import com.qa.cinema.service.BookingService;

@SpringBootTest
public class BookingServiceUnitTesting {

	@Autowired
	private BookingService service;

	@MockBean
	private BookingRepo repo;

	@Test
	public void createBookingForm_validForm_SaveForm() {
		Booking validBooking = new Booking(1L, 1L, "31-08-22", 1L);

		Booking saveBooking = new Booking(1L, "31-08-22", 1L);

		Mockito.when(this.service.addBooking(saveBooking)).thenReturn(validBooking);
		assertEquals(validBooking, this.service.addBooking(saveBooking));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveBooking);
	}

	@Test
	public void updateBooking_validBooking_updateBooking() {
		Booking validBooking = new Booking(1L, 1L, "31-08-22", 1L);

		Booking updateBooking = new Booking(2L, "01-09-22", 2L);

		Mockito.when(this.repo.findById(validBooking.getId())).thenReturn(Optional.of(validBooking));
		this.service.updateBooking(updateBooking, validBooking.getId());

		Mockito.verify(this.repo, Mockito.times(1)).save(validBooking);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validBooking.getId());
	}

	@Test
	public void deleteBooking_Booking() {
		Booking validBooking = new Booking(1L, 1L, "31-08-22", 1L);

		Mockito.when(this.repo.findById(validBooking.getId())).thenReturn(Optional.of(validBooking));
		this.service.deleteByBookingID(validBooking.getId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validBooking.getId());
	}

	@Test
	public void deleteBooking_InvalidBooking_Unsucessful() {
		Booking invalidBooking = new Booking();
		invalidBooking.setId(86L);
		invalidBooking.setBookingDate("11/08/2023");

		Mockito.when(this.repo.findById(invalidBooking.getId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteByBookingID(invalidBooking.getId());
	}

	@Test
	public void readBookings_validBookings_Bookings() {
		List<Booking> bookings = new ArrayList<>();
		bookings.add(new Booking(1L, 1L, "31-08-22", 1L));
		Mockito.when(this.service.readAll()).thenReturn(bookings);
		assertEquals(bookings, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).allFromBooking();
	}

	@Test
	public void readOneBooking_validBooking_oneBooking() {
		Booking validBooking = new Booking(1L, 1L, "31-08-22", 1L);
		Mockito.when(this.repo.findById(validBooking.getId())).thenReturn(Optional.of(validBooking));
		assertThat(this.service.readBooking(validBooking.getId())).isEqualTo(validBooking);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validBooking.getId());
	}

}
