package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Viewing;

@Repository
public interface ViewingRepo extends JpaRepository<Viewing, Long> {
	// custom queries

	@Query(value = "SELECT * FROM viewing", nativeQuery = true)
	public List<Viewing> allFromViewing();

}
