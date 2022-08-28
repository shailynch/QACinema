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

import com.qa.cinema.models.Appointment;
import com.qa.cinema.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private final AppointmentService service;

	@Autowired
	AppointmentController(AppointmentService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Appointment> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newAppointmentForm(@RequestBody Appointment appointment) {
		Appointment newAppointment = appointment;
		service.addAppointment(newAppointment);
		return appointment.toString();
	}

	@GetMapping("/{id}")
	Appointment one(@PathVariable Long id) {

		return service.readAppointment(id);
//      .orElseThrow(() -> new AppointmentNotFoundException(id));
	}

//	@PutMapping("/appointments/{id}")
//	Appointment replaceAppointment(@RequestBody Appointment newAppointment, @PathVariable Long id) {
//
//		return service.readAppointment(id).map(appointment -> {
//			appointment.setFirstName(newAppointment.getFirstName());
//			appointment.setLastName(newAppointment.getLastName());
//			appointment.setEmail(newAppointment.getEmail());
//
//			return repository.save(appointment);
//		}).orElseGet(() -> {
//			newAppointment.setId(id);
//			return repository.save(newAppointment);
//		});
//	}

	@DeleteMapping("/{id}")
	void deleteAppointment(@PathVariable Long id) {
		service.deleteByAppointmentID(id);
	}
}