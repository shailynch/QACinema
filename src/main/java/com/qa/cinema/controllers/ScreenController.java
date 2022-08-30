package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.Screen;
import com.qa.cinema.service.ScreenService;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	private final ScreenService service;

	@Autowired
	ScreenController(ScreenService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Screen> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newScreenForm(@RequestBody Screen screen) {
		Screen newScreen = screen;
		service.addScreen(newScreen);
		return screen.toString();
	}

	@GetMapping("/{id}")
	Screen one(@PathVariable Long id) {

		return service.readScreen(id);
//      .orElseThrow(() -> new ScreenNotFoundException(id));
	}

//	@PutMapping("/screens/{id}")
//	Screen replaceScreen(@RequestBody Screen newScreen, @PathVariable Long id) {
//
//		return service.readScreen(id).map(screen -> {
//			screen.setFirstName(newScreen.getFirstName());
//			screen.setLastName(newScreen.getLastName());
//			screen.setEmail(newScreen.getEmail());
//
//			return repository.save(screen);
//		}).orElseGet(() -> {
//			newScreen.setId(id);
//			return repository.save(newScreen);
//		});
//	}

	@DeleteMapping("/{id}")
	void deleteScreen(@PathVariable Long id) {
		service.deleteByScreenID(id);
	}
}