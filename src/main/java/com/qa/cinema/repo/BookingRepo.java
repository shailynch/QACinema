package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
	// custom queries

	@Query(value = "SELECT * FROM booking", nativeQuery = true)
	public List<Booking> allFromBooking();

}
