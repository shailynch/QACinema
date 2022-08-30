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

import com.qa.cinema.models.Viewing;
import com.qa.cinema.service.ViewingService;

@RestController
@RequestMapping("/viewing")
public class ViewingController {

	private final ViewingService service;

	@Autowired
	ViewingController(ViewingService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Viewing> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newViewingForm(@RequestBody Viewing viewing) {
		Viewing newViewing = viewing;
		service.addViewing(newViewing);
		return viewing.toString();
	}

	@GetMapping("/{id}")
	Viewing one(@PathVariable Long id) {

		return service.readViewing(id);
//      .orElseThrow(() -> new ViewingNotFoundException(id));
	}

//	@PutMapping("/viewings/{id}")
//	Viewing replaceViewing(@RequestBody Viewing newViewing, @PathVariable Long id) {
//
//		return service.readViewing(id).map(viewing -> {
//			viewing.setFirstName(newViewing.getFirstName());
//			viewing.setLastName(newViewing.getLastName());
//			viewing.setEmail(newViewing.getEmail());
//
//			return repository.save(viewing);
//		}).orElseGet(() -> {
//			newViewing.setId(id);
//			return repository.save(newViewing);
//		});
//	}

	@DeleteMapping("/{id}")
	void deleteViewing(@PathVariable Long id) {
		service.deleteByViewingID(id);
	}
}