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

import com.qa.cinema.controllers.ViewingController;
import com.qa.cinema.models.Viewing;
import com.qa.cinema.repo.ViewingRepo;
import com.qa.cinema.service.ViewingService;

@SpringBootTest
public class ViewingControllerUnitTests {

	@Autowired
	private ViewingController controller;

	@MockBean
	private ViewingService service;

	@MockBean
	private ViewingRepo repo;

	@Test
	public void createViewingTest() throws Exception {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12");
		Mockito.when(this.service.addViewing(validViewing)).thenReturn(validViewing);
		ResponseEntity<Viewing> response = new ResponseEntity<Viewing>(validViewing, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.newViewingForm(validViewing));
		Mockito.verify(this.service, Mockito.times(1)).addViewing(validViewing);
	}

	@Test
	public void getAllMoviesTest() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12");
		List<Viewing> viewings = new ArrayList<>();
		viewings.add(validViewing);
		Mockito.when(this.service.readAll()).thenReturn(viewings);
		assertThat(viewings).isEqualTo(controller.getAllViewings());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void getMovieById() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12");
		List<Viewing> viewings = new ArrayList<>();
		viewings.add(validViewing);

		Mockito.when(this.service.readViewing(validViewing.getId())).thenReturn(viewings.get(0));

		Viewing value = viewings.get(0);

		assertThat(value).isEqualTo(controller.readViewingById(validViewing.getId()));

		Mockito.verify(this.service, Mockito.times(1)).readViewing(validViewing.getId());
	}

	@Test
	public void updateMovieById() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12");
		List<Viewing> viewings = new ArrayList<>();
		viewings.add(validViewing);

		Viewing updateViewing = new Viewing(2L, 2L, "13");

		Mockito.when(this.service.updateViewing(updateViewing, validViewing.getId())).thenReturn(validViewing);
		ResponseEntity<Viewing> response = new ResponseEntity<Viewing>(validViewing, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateViewingById(validViewing.getId(), updateViewing));
		Mockito.verify(this.service, Mockito.times(1)).updateViewing(updateViewing, validViewing.getId());
	}

	@Test
	public void deleteMovietest() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12");
		List<Viewing> viewings = new ArrayList<>();
		viewings.add(validViewing);

		Mockito.when(this.service.deleteByViewingID(validViewing.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteViewing(validViewing.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByViewingID(validViewing.getId());

	}

}
