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

import com.qa.cinema.controllers.ScreenController;
import com.qa.cinema.models.Screen;
import com.qa.cinema.service.ScreenService;

@SpringBootTest
public class ScreenControllerUnitTesting {

	@Autowired
	private ScreenController controller;

	@MockBean
	private ScreenService service;

	@Test
	public void createScreenTest() throws Exception {
		Screen validScreen = new Screen(1L, 120L);

		Mockito.when(this.service.addScreen(validScreen)).thenReturn(validScreen);
		ResponseEntity<Screen> response = new ResponseEntity<Screen>(validScreen, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.addScreen(validScreen));
		Mockito.verify(this.service, Mockito.times(1)).addScreen(validScreen);
	}

	@Test
	public void getAllScreensTest() throws Exception {
		Screen validScreen = new Screen(1L, 120L);

		List<Screen> screens = new ArrayList<>();
		screens.add(validScreen);

		Mockito.when(this.service.readAll()).thenReturn(screens);
		assertThat(screens).isEqualTo(controller.getAllScreens());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void getScreenByIdTest() throws Exception {
		Screen validScreen = new Screen(1L, 120L);

		List<Screen> screens = new ArrayList<>();
		screens.add(validScreen);

		Mockito.when(this.service.readScreen(validScreen.getId())).thenReturn(screens.get(0));
		Screen value = screens.get(0);

		assertThat(value).isEqualTo(controller.getScreenById(validScreen.getId()));
		Mockito.verify(this.service, Mockito.times(1)).readScreen(validScreen.getId());
	}

	@Test
	public void updateScreenByIdTest() {
		Screen validScreen = new Screen(1L, 120L);

		List<Screen> screens = new ArrayList<>();
		screens.add(validScreen);

		Screen updateScreen = new Screen(130L);

		Mockito.when(this.service.updateScreen(updateScreen, validScreen.getId())).thenReturn(validScreen);
		ResponseEntity<Screen> response = new ResponseEntity<Screen>(validScreen, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateScreenById(validScreen.getId(), updateScreen));
		Mockito.verify(this.service, Mockito.times(1)).updateScreen(updateScreen, validScreen.getId());
	}

	@Test
	public void deleteScreenById_SuccessfulTest() {
		Screen validScreen = new Screen(1L, 120L);

		List<Screen> screens = new ArrayList<>();
		screens.add(validScreen);

		Mockito.when(this.service.deleteByScreenID(validScreen.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteScreen(validScreen.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByScreenID(validScreen.getId());
	}

	@Test
	public void deleteCustomerById_UnsuccessfullTest() {
		Screen invalidScreen = new Screen(1L, 120L);

		List<Screen> screens = new ArrayList<>();
		screens.add(invalidScreen);

		Mockito.when(this.service.deleteByScreenID(invalidScreen.getId())).thenReturn(false);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		assertThat(response).isEqualTo(controller.deleteScreen(invalidScreen.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByScreenID(invalidScreen.getId());
	}

}
