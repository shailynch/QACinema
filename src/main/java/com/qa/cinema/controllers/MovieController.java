package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.qa.cinema.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService service;

	public MovieController(MovieService service) {
		this.service = service;
	}

	@CrossOrigin
	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		Movie createMovie = service.addMovie(movie);
		return new ResponseEntity<Movie>(createMovie, HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Movie readMovieById(@PathVariable Long id) {

		return service.readMovie(id);
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> updateMovieById(@PathVariable("movieId") Long Id, @RequestBody Movie movie) {
		Movie updatedMovie = this.service.updateMovie(movie, Id);
		return new ResponseEntity<Movie>(updatedMovie, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteByMovieID(id), HttpStatus.NO_CONTENT);
	}
}