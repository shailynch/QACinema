package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Movie;
import com.qa.cinema.repo.MovieRepo;

@Component
public class MovieService {
	private Movie movie;
	private MovieRepo repo;

	@Autowired
	public MovieService(MovieRepo repo) {
		super();
		this.movie = new Movie();
		this.repo = repo;
	}

	// create
	public Movie addMovie(Movie newMovie) {
		return repo.save(newMovie);
	}

	// read
	public Movie readMovie(Long id) {
		return repo.findById(id).get();
		// .get returns null or the movie as the movie would be optional
		// type check would be better
	}

	public List<Movie> readAll() {
		return repo.allFromMovie();
		// .get returns null or the movie as the movie would be optional
		// type check would be better
	}

	// update - change to current movie and new movie
	public Movie updateMovie(Movie updateMovie, Long id) {
		Optional<Movie> currentMovie = this.repo.findById(id);
		if (currentMovie.get() instanceof Movie) {
			Movie oldMovie = currentMovie.get();
			oldMovie.setTitle(updateMovie.getTitle());
			oldMovie.setRuntime(updateMovie.getRuntime());
			oldMovie.setCast(updateMovie.getCast());
			oldMovie.setGenre(updateMovie.getGenre());
			oldMovie.setReleaseDate(updateMovie.getReleaseDate());
			oldMovie.setAgeRating(updateMovie.getAgeRating());
			oldMovie.setDescription(updateMovie.getDescription());
			oldMovie.setPosterUrl(updateMovie.getPosterUrl());
			return repo.save(oldMovie);
		}
		return null;

	}

	// delete
	public boolean deleteByMovieID(Long id) {
		Optional<Movie> currentMovie = this.repo.findById(id);
		boolean isPresent = (currentMovie.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
