package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Screen;
import com.qa.cinema.repo.ScreenRepo;

@Component
public class ScreenService {
	private Screen screen;
	private ScreenRepo repo;

	@Autowired
	public ScreenService(ScreenRepo repo) {
		super();
		this.screen = new Screen();
		this.repo = repo;
	}

	// create
	public Screen addScreen(Screen newScreen) {
		return repo.save(newScreen);
	}

	// read
	public Screen readScreen(Long id) {
		return repo.findById(id).get();
		// .get returns null or the screen as the screen would be optional
		// type check would be better
	}

	public List<Screen> readAll() {
		return repo.allFromScreen();
		// .get returns null or the screen as the screen would be optional
		// type check would be better
	}

	// update - change to current screen and new screen
	public Screen updateScreen(Screen updateScreen, Long id) {
		Optional<Screen> currentScreen = this.repo.findById(id);
		if (currentScreen.get() instanceof Screen) {
			Screen oldScreen = currentScreen.get();
			oldScreen.setCapacity(updateScreen.getCapacity());

			return repo.save(oldScreen);
		}
		return null;

	}

	// delete
	public boolean deleteByScreenID(Long id) {
		Optional<Screen> currentScreen = this.repo.findById(id);
		boolean isPresent = (currentScreen.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
