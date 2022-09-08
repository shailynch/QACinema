package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	// custom queries

	@Query(value = "SELECT * FROM movie", nativeQuery = true)
	public List<Movie> allFromMovie();

	@Query(value = "SELECT * FROM movie WHERE name = ?1", nativeQuery = true)
	public List<Movie> movieNameMatch(String name);

	@Query(value = "SELECT * FROM movie WHERE id = ?1", nativeQuery = true)
	public static Movie findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Query(value = "SELECT * FROM movie WHERE title = ?1", nativeQuery = true)
	public static Movie findByTitle(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
