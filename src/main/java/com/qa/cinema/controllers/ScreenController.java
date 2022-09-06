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

	@CrossOrigin
	@GetMapping("/all")
	public List<Screen> getAllScreens() {
		return service.readAll();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Screen getScreenById(@PathVariable Long id) {
		return service.readScreen(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
		Screen createScreen = service.addScreen(screen);
		return new ResponseEntity<Screen>(createScreen, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Screen> updateScreenById(@PathVariable Long id, @RequestBody Screen screen) {
		Screen updatedScreen = this.service.updateScreen(screen, id);
		return new ResponseEntity<Screen>(updatedScreen, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteScreen(@PathVariable Long id) {

		Boolean deletedScreen = service.deleteByScreenID(id);

		return (deletedScreen) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}