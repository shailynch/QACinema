package com.qa.vet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.vet.models.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	// custom queries

	@Query(value = "SELECT * FROM appointment", nativeQuery = true)
	public List<Appointment> allFromAppointment();

}
