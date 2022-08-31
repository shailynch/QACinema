package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Booking;

import nl.jqno.equalsverifier.EqualsVerifier;

public class BookingTest {

	static Booking booking;

	@BeforeAll
	public static void createBooking() {
		System.out.println("Creating Booking");
		booking = new Booking(1L, 1L, "31-08-22", 1L);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Booking.class)
				.withPrefabValues(Booking.class, new Booking(1L, "31-08-22", 1L), new Booking(2L, "30-08-22", 2L))
				.verify();
	}

	@Test
	public void testToString() {
		String expecting = "Appointment [Id=" + booking.getId() + ", viewingID=" + booking.getViewingID()
				+ ", bookingDate=" + booking.getBookingDate() + ", customerID=" + booking.getCustomerID() + "]";
		assertEquals(expecting, booking.toString());
	}

	@Test
	public void constructorTests() {
		Booking booking1 = new Booking();
		Booking booking2 = new Booking(3L, "31-08-22", 3L);
		Booking booking3 = new Booking(4L, 4L, "31-08-22", 4L);

		assertTrue(booking1 instanceof Booking == true);
		assertTrue(booking2 instanceof Booking == true);
		assertTrue(booking3 instanceof Booking == true);

	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Booking testBooking = new Booking();
		testBooking.setId(5L);

		Field expected = testBooking.getClass().getDeclaredField("Id");
		expected.setAccessible(true);
		assertEquals(expected.get(testBooking), 5L);

	}

	@Test
	public void setCustomerIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Booking testBooking = new Booking();
		testBooking.setCustomerID(2L);

		Field expected = testBooking.getClass().getDeclaredField("customerID");
		expected.setAccessible(true);
		assertEquals(expected.get(testBooking), 2L);

	}

	@Test
	public void setViewingIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Booking testBooking = new Booking();
		testBooking.setViewingID(2L);

		Field expected = testBooking.getClass().getDeclaredField("viewingID");
		expected.setAccessible(true);
		assertEquals(expected.get(testBooking), 2L);

	}

	@Test
	public void setBookingDateTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Booking testBooking = new Booking();
		testBooking.setBookingDate("31-08-22");

		Field expected = testBooking.getClass().getDeclaredField("bookingDate");
		expected.setAccessible(true);
		assertEquals(expected.get(testBooking), "31-08-22");

	}
}
