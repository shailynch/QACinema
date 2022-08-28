package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.Pet;
import com.qa.cinema.repo.PetRepo;
import com.qa.cinema.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	private final PetService service;

	@Autowired
	PetController(PetService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Pet> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newPetForm(@RequestBody Pet pet) {
		Pet newPet = pet;
		service.addPet(newPet);
		return pet.toString();
	}

	@GetMapping("/{id}")
	Pet one(@PathVariable Long id) {

		return service.readPet(id);
//      .orElseThrow(() -> new PetNotFoundException(id));
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public String updatePetForm(@PathVariable Long id, @RequestBody Pet pet) {
		Pet existing;
		try {
			existing = PetRepo.findByID(id);
			existing.setName(pet.getName());
			existing.setType(pet.getType());
			existing.setCustomerID(pet.getCustomerID());

			return pet.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Pet newPet = pet;
			service.addPet(newPet);
			return pet.toString();
		}

	}

	@DeleteMapping("/{id}")
	void deletePet(@PathVariable Long id) {
		service.deleteByPetID(id);
	}
}