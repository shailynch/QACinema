package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cinema.models.Movie;
import com.qa.cinema.repo.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo repo;

	@Autowired
	public MovieService(MovieRepo repo) {
		this.repo = repo;
	}

	// create
	public Movie addMovie(Movie newMovie) {
		return repo.save(newMovie);
	}

	// read
	public Movie readMovie(Long id) {
		return repo.findById(id).get();
	}

	public List<Movie> readAll() {
		return repo.allFromMovie();
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
			oldMovie.setFilmImg1(updateMovie.getFilmImg1());
			oldMovie.setFilmImg2(updateMovie.getFilmImg2());
			oldMovie.setFilmImg3(updateMovie.getFilmImg3());
			return repo.save(oldMovie);
		}
		return null;
	}

	public Movie newReleaseMovie(Movie newReleaseMovie, Long id) {
		Optional<Movie> currentMovie = this.repo.findById(id);
		if (currentMovie.get() instanceof Movie) {
			Movie oldMovie = currentMovie.get();
			oldMovie.setNewRelease(newReleaseMovie.getNewRelease());
			return repo.save(newReleaseMovie);
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
