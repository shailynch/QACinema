package com.qa.vet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.vet.models.Vet;

@Repository
public interface VetRepo extends JpaRepository<Vet, Long> {
	// custom queries

	@Query(value = "SELECT * FROM vet", nativeQuery = true)
	public List<Vet> allFromVet();

	@Query(value = "SELECT * FROM vet WHERE name = ?1", nativeQuery = true)
	public List<Vet> vetNameMatch(String name);

}
