package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Pet;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {
	// custom queries

	@Query(value = "SELECT * FROM pet", nativeQuery = true)
	public List<Pet> allFromPet();

	@Query(value = "SELECT * FROM pet WHERE name = ?1", nativeQuery = true)
	public List<Pet> petNameMatch(String name);

	@Query(value = "SELECT * FROM pet WHERE id = ?1", nativeQuery = true)
	public static Pet findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
