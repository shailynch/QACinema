package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Pet;
import com.qa.cinema.repo.PetRepo;

@Component
public class PetService {
	private Pet pet;
	private PetRepo repo;

	@Autowired
	public PetService(PetRepo repo) {
		super();
		this.pet = new Pet();
		this.repo = repo;
	}

	// create
	public Pet addPet(Pet newPet) {
		return repo.save(newPet);
	}

	// read
	public Pet readPet(Long id) {
		return repo.findById(id).get();
		// .get returns null or the pet as the pet would be optional
		// type check would be better
	}

	public List<Pet> readAll() {
		return repo.allFromPet();
		// .get returns null or the pet as the pet would be optional
		// type check would be better
	}

	// update - change to current pet and new pet
	public Pet updatePet(Pet updatePet, Long id) {
		Optional<Pet> currentPet = this.repo.findById(id);
		if (currentPet.get() instanceof Pet) {
			Pet oldPet = currentPet.get();
			oldPet.setName(updatePet.getName());
			oldPet.setType(updatePet.getType());
			oldPet.setCustomerID(updatePet.getCustomerID());

			return repo.save(oldPet);
		}
		return null;

	}

	// delete
	public boolean deleteByPetID(Long id) {
		Optional<Pet> currentPet = this.repo.findById(id);
		boolean isPresent = (currentPet.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
