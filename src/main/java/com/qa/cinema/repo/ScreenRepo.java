package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Long> {
	// custom queries

	@Query(value = "SELECT * FROM screen", nativeQuery = true)
	public List<Screen> allFromScreen();

}
