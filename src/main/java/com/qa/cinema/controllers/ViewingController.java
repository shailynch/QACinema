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

import com.qa.cinema.models.Viewing;
import com.qa.cinema.service.ViewingService;

@RestController
@RequestMapping("/viewing")
public class ViewingController {

	private final ViewingService service;

	@Autowired
	ViewingController(ViewingService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Viewing> getAllViewings() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Viewing> newViewingForm(@RequestBody Viewing viewing) {
		Viewing createViewing = service.addViewing(viewing);
		return new ResponseEntity<Viewing>(createViewing, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Viewing readViewingById(@PathVariable Long id) {

		return service.readViewing(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Viewing> updateViewingById(@PathVariable("movieId") Long Id, @RequestBody Viewing viewing) {
		Viewing updatedViewing = this.service.updateViewing(viewing, Id);
		return new ResponseEntity<Viewing>(updatedViewing, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteViewing(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteByViewingID(id), HttpStatus.NO_CONTENT);
	}
}