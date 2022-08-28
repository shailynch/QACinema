package com.qa.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.vet.models.Vet;
import com.qa.vet.repo.VetRepo;

@Component
public class VetService {
	private Vet vet;
	private VetRepo repo;

	@Autowired
	public VetService(VetRepo repo) {
		super();
		this.vet = new Vet();
		this.repo = repo;
	}

	// create
	public Vet addVet(Vet newVet) {
		return repo.save(newVet);
	}

	// read
	public Vet readVet(Long id) {
		return repo.findById(id).get();
		// .get returns null or the vet as the vet would be optional
		// type check would be better
	}

	public List<Vet> readAll() {
		return repo.allFromVet();
		// .get returns null or the vet as the vet would be optional
		// type check would be better
	}

	// update - change to current vet and new vet
	public Vet updateVet(Vet updateVet, Long id) {
		Optional<Vet> currentVet = this.repo.findById(id);
		if (currentVet.get() instanceof Vet) {
			Vet oldVet = currentVet.get();
			oldVet.setFirstName(updateVet.getFirstName());
			oldVet.setLastName(updateVet.getLastName());
			oldVet.setEmail(updateVet.getEmail());

			return repo.save(oldVet);
		}
		return null;

	}

	// delete
	public boolean deleteByVetID(Long id) {
		Optional<Vet> currentVet = this.repo.findById(id);
		boolean isPresent = (currentVet.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
