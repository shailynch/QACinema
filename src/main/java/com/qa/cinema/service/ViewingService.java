package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Viewing;
import com.qa.cinema.repo.ViewingRepo;

@Component
public class ViewingService {
	private Viewing viewing;
	private ViewingRepo repo;

	@Autowired
	public ViewingService(ViewingRepo repo) {
		super();
		this.viewing = new Viewing();
		this.repo = repo;
	}

	// create
	public Viewing addViewing(Viewing newViewing) {
		return repo.save(newViewing);
	}

	// read
	public Viewing readViewing(Long id) {
		return repo.findById(id).get();
		// .get returns null or the viewing as the viewing would be optional
		// type check would be better
	}

	public List<Viewing> readAll() {
		return repo.allFromViewing();
		// .get returns null or the viewing as the viewing would be optional
		// type check would be better
	}

	// update - change to current viewing and new viewing
	public Viewing updateViewing(Viewing updateViewing, Long id) {
		Optional<Viewing> currentViewing = this.repo.findById(id);
		if (currentViewing.get() instanceof Viewing) {
			Viewing oldViewing = currentViewing.get();
			oldViewing.setScreenID(updateViewing.getScreenID());
			oldViewing.setMovieID(updateViewing.getMovieID());
			oldViewing.setStartTime(updateViewing.getStartTime());

			return repo.save(oldViewing);
		}
		return null;

	}

	// delete
	public boolean deleteByViewingID(Long id) {
		Optional<Viewing> currentViewing = this.repo.findById(id);
		boolean isPresent = (currentViewing.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
