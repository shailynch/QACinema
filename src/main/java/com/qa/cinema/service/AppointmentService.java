package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Appointment;
import com.qa.cinema.repo.AppointmentRepo;

@Component
public class AppointmentService {
	private Appointment appointment;
	private AppointmentRepo repo;

	@Autowired
	public AppointmentService(AppointmentRepo repo) {
		super();
		this.appointment = new Appointment();
		this.repo = repo;
	}

	// create
	public Appointment addAppointment(Appointment newAppointment) {
		return repo.save(newAppointment);
	}

	// read
	public Appointment readAppointment(Long id) {
		return repo.findById(id).get();
		// .get returns null or the appointment as the appointment would be optional
		// type check would be better
	}

	public List<Appointment> readAll() {
		return repo.allFromAppointment();
		// .get returns null or the appointment as the appointment would be optional
		// type check would be better
	}

	// update - change to current appointment and new appointment
	public Appointment updateAppointment(Appointment updateAppointment, Long id) {
		Optional<Appointment> currentAppointment = this.repo.findById(id);
		if (currentAppointment.get() instanceof Appointment) {
			Appointment oldAppointment = currentAppointment.get();
			oldAppointment.setCustomerID(updateAppointment.getCustomerID());
			oldAppointment.setVetID(updateAppointment.getVetID());
			oldAppointment.setPetID(updateAppointment.getPetID());

			return repo.save(oldAppointment);
		}
		return null;

	}

	// delete
	public boolean deleteByAppointmentID(Long id) {
		Optional<Appointment> currentAppointment = this.repo.findById(id);
		boolean isPresent = (currentAppointment.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
