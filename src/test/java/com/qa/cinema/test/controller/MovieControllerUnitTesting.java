
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
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
		Mockito.when(this.service.addMovie(validMovie)).thenReturn(validMovie);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(validMovie, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.addMovie(validMovie));
		Mockito.verify(this.service, Mockito.times(1)).addMovie(validMovie);
	}

	@Test
	public void getAllMoviesTest() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);
		Mockito.when(this.service.readAll()).thenReturn(movies);
		assertThat(movies).isEqualTo(controller.getAllMovies());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void getMovieById() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);

		Mockito.when(this.service.readMovie(validMovie.getId())).thenReturn(movies.get(0));

		Movie value = movies.get(0);

		assertThat(value).isEqualTo(controller.readMovieById(validMovie.getId()));

		Mockito.verify(this.service, Mockito.times(1)).readMovie(validMovie.getId());
	}

	@Test
	public void updateMovieById() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);

		Movie updateMovie = new Movie("movie", 90, "bill", "genre", "87", "12", "descr", "image", false);

		Mockito.when(this.service.updateMovie(updateMovie, validMovie.getId())).thenReturn(validMovie);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(validMovie, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateMovieById(validMovie.getId(), updateMovie));
		Mockito.verify(this.service, Mockito.times(1)).updateMovie(updateMovie, validMovie.getId());
	}

//	@Test
//	public void updateNewReleaseById() {
//		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
//		List<Movie> movies = new ArrayList<>();
//		movies.add(validMovie);
//
//		Movie newMovie = new Movie();
//		validMovie.setNewRelease(true);
//
//		Mockito.when(this.service.newReleaseMovie(newMovie, validMovie.getId())).thenReturn(validMovie);
//		ResponseEntity<Movie> response = new ResponseEntity<Movie>(validMovie, HttpStatus.OK);
//		assertThat(response).isEqualTo(controller.newRelease(validMovie.getId(), newMovie));
//		Mockito.verify(this.service, Mockito.times(1)).newReleaseMovie(newMovie, validMovie.getId());
//	}

	@Test
	public void deleteMovietest() {
		Movie validMovie = new Movie(1L, "Top Gun", 120, "tommy c", "action", "22", "15", "desc", "url", false);
		List<Movie> movies = new ArrayList<>();
		movies.add(validMovie);

		Mockito.when(this.service.deleteByMovieID(validMovie.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteMovie(validMovie.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByMovieID(validMovie.getId());

	}

}
