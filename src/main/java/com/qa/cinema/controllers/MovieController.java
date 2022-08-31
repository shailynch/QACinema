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

import com.qa.cinema.models.Movie;
import com.qa.cinema.repo.MovieRepo;
import com.qa.cinema.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Movie> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newMovieForm(@RequestBody Movie movie) {
		Movie newMovie = movie;
		service.addMovie(newMovie);
		return movie.toString();
	}

//	@CrossOrigin
//	@PostMapping("/add")
//	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
//		Movie createMovie = service.addMovie(movie);
//		return new ResponseEntity<Movie>(createMovie, HttpStatus.CREATED);
//	}

	@GetMapping("/{id}")
	Movie one(@PathVariable Long id) {

		return service.readMovie(id);
//      .orElseThrow(() -> new MovieNotFoundException(id));
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public String updateMovieForm(@PathVariable Long id, @RequestBody Movie movie) {
		Movie existing;
		try {
			existing = MovieRepo.findByID(id);
			existing.setTitle(movie.getTitle());
			existing.setRuntime(movie.getRuntime());
			existing.setCast(movie.getCast());
			existing.setGenre(movie.getGenre());
			existing.setReleaseDate(movie.getReleaseDate());
			existing.setAgeRating(movie.getAgeRating());
			existing.setDescription(movie.getDescription());
			existing.setPosterUrl(movie.getPosterUrl());

			return movie.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Movie newMovie = movie;
			service.addMovie(newMovie);
			return movie.toString();
		}

	}

	@DeleteMapping("/{id}")
	void deleteMovie(@PathVariable Long id) {
		service.deleteByMovieID(id);
	}
}