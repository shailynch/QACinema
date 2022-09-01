
package com.qa.cinema.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.cinema.controllers.MovieController;
import com.qa.cinema.models.Movie;
import com.qa.cinema.repo.MovieRepo;
import com.qa.cinema.service.MovieService;

@SpringBootTest
public class MovieControllerUnitTesting {

	@Autowired
	private MovieController controller;

	@MockBean
	private MovieService service;

	@MockBean
	private MovieRepo repo;

	@Test
	public void createMovieTest() throws Exception {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url");
		Mockito.when(this.service.addMovie(validMovie)).thenReturn(validMovie);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(validMovie, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.addMovie(validMovie));
		Mockito.verify(this.service, Mockito.times(1)).addMovie(validMovie);
	}

	@Test
	public void getAllMoviesTest() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url");
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);
		Mockito.when(this.service.readAll()).thenReturn(movies);
		assertThat(movies).isEqualTo(controller.getAllMovies());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void updateMovieById() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url");
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);

		Movie updateMovie = new Movie("movie", 90, "bill", "genre", "87", "12", "descr", "image");

		Mockito.when(this.service.updateMovie(updateMovie, validMovie.getId())).thenReturn(validMovie);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(validMovie, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateMovieById(validMovie.getId(), updateMovie));
		Mockito.verify(this.service, Mockito.times(1)).updateMovie(updateMovie, validMovie.getId());
	}

}
