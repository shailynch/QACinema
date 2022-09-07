package com.qa.cinema.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.cinema.models.Movie;
import com.qa.cinema.repo.MovieRepo;
import com.qa.cinema.service.MovieService;

@SpringBootTest
public class MovieServiceUnitTesting {

	@Autowired
	private MovieService service;

	@MockBean
	private MovieRepo repo;

	@Test
	public void createMovie_ValidMovie_SaveMovie() {
		Movie validMovie = new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U",
				"A tale about a deer", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", "https://picsum.photos/200", false);
		Movie saveMovie = new Movie("Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U", "A tale about a deer",
				"https://picsum.photos/200", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", false);

		Mockito.when(this.service.addMovie(saveMovie)).thenReturn(validMovie);
		assertEquals(validMovie, this.service.addMovie(saveMovie));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveMovie);
	}

	@Test
	public void readMovies_ValidMovies_Movies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U", "A tale about a deer",
				"https://picsum.photos/200", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", false));

		Mockito.when(this.service.readAll()).thenReturn(movies);
		assertEquals(movies, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).allFromMovie();
	}

	@Test
	public void readOneMovie_ValidMovie_OneMovie() {
		Movie validMovie = new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U",
				"A tale about a deer", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", "https://picsum.photos/200", false);

		Mockito.when(this.repo.findById(validMovie.getId())).thenReturn(Optional.of(validMovie));
		assertThat(this.service.readMovie(validMovie.getId())).isEqualTo(validMovie);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validMovie.getId());

	}

	@Test
	public void updateMovie_ValidMovie_UpdatedMovie() {
		Movie validMovie = new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U",
				"A tale about a deer", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", "https://picsum.photos/200", false);

		Movie newMovie = new Movie("Finding Paul", 190, "Barry Chuckle", "Kids", "20/08/2022", "18",
				"Barry's search for his brother Paul", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", "https://picsum.photos/200", false);

		Mockito.when(this.repo.findById(validMovie.getId())).thenReturn(Optional.of(validMovie));
		this.service.updateMovie(newMovie, validMovie.getId());

		Mockito.verify(this.repo, Mockito.times(1)).save(validMovie);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validMovie.getId());

	}

	@Test
	public void deleteMovie_Movie() {
		Movie validMovie = new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U",
				"A tale about a deer", "https://picsum.photos/200", "https://picsum.photos/200",
				"https://picsum.photos/200", "https://picsum.photos/200", false);

		Mockito.when(this.repo.findById(validMovie.getId())).thenReturn(Optional.of(validMovie));
		this.service.deleteByMovieID(validMovie.getId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validMovie.getId());
	}

	@Test
	public void deleteMovie_invalidMovie_Unsuccessful() {
		Movie invalidMovie = new Movie();
		invalidMovie.setId(88L);
		invalidMovie.setTitle("Bambi 2: The Return of The Hunter");

		Mockito.when(this.repo.findById(invalidMovie.getId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteByMovieID(invalidMovie.getId());
	}

//	@Test
//	public void saveFilm_ValidFilm_SavedFilm() {
//		Movie validMovie = new Movie(1L, "Bambi", 88, "Bambi, Thumper", "Horror", "14/05/1945", "U",
//				"A tale about a deer", "https://picsum.photos/200", false);
//
//		Movie newMovie = new Movie();
//		validMovie.setNewRelease(true);
//
//		Mockito.when(this.repo.findById(validMovie.getId())).thenReturn(Optional.of(validMovie));
//		this.service.newReleaseMovie(newMovie, validMovie.getId());
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(validMovie);
//		Mockito.verify(this.repo, Mockito.times(1)).findById(validMovie.getId());
//	}

}
