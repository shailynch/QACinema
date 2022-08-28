package com.qa.vet.controllers;

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

import com.qa.vet.models.Vet;
import com.qa.vet.service.VetService;

@RestController
@RequestMapping("/vet")
public class VetController {

	private final VetService service;

	@Autowired
	VetController(VetService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Vet> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newVetForm(@RequestBody Vet vet) {
		Vet newVet = vet;
		service.addVet(newVet);
		return vet.toString();
	}

	@GetMapping("/{id}")
	Vet one(@PathVariable Long id) {

		return service.readVet(id);
//      .orElseThrow(() -> new VetNotFoundException(id));
	}

//	@PutMapping("/vets/{id}")
//	Vet replaceVet(@RequestBody Vet newVet, @PathVariable Long id) {
//
//		return service.readVet(id).map(vet -> {
//			vet.setFirstName(newVet.getFirstName());
//			vet.setLastName(newVet.getLastName());
//			vet.setEmail(newVet.getEmail());
//
//			return repository.save(vet);
//		}).orElseGet(() -> {
//			newVet.setId(id);
//			return repository.save(newVet);
//		});
//	}

	@DeleteMapping("/{id}")
	void deleteVet(@PathVariable Long id) {
		service.deleteByVetID(id);
	}
}