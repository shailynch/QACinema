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

import com.qa.cinema.models.Screen;
import com.qa.cinema.repo.ScreenRepo;
import com.qa.cinema.service.ScreenService;

@SpringBootTest
public class ScreenServiceUnitTest {

	@Autowired
	private ScreenService service;

	@MockBean
	private ScreenRepo repo;

	@Test
	public void createScreen_validScreen_SaveScreen() {
		Screen validScreen = new Screen(1L, 200L);
		Screen saveScreen = new Screen(200L);

		Mockito.when(this.service.addScreen(saveScreen)).thenReturn(validScreen);
		assertEquals(validScreen, this.service.addScreen(saveScreen));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveScreen);
	}

	@Test
	public void readScreen_validScreen_Screen() {
		List<Screen> screens = new ArrayList<>();
		screens.add(new Screen(2L, 200L));

		Mockito.when(this.service.readAll()).thenReturn(screens);
		assertEquals(screens, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).allFromScreen();
	}

	@Test
	public void readOneScreen_ValidScreen_OneScreen() {
		Screen validScreen = new Screen(3L, 200L);

		Mockito.when(this.repo.findById(validScreen.getId())).thenReturn(Optional.of(validScreen));
		assertThat(this.service.readScreen(validScreen.getId())).isEqualTo(validScreen);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validScreen.getId());
	}

	@Test
	public void deleteScreen_Screen() {
		Screen validScreen = new Screen(3L, 200L);

		Mockito.when(this.repo.findById(validScreen.getId())).thenReturn(Optional.of(validScreen));
		this.service.deleteByScreenID(validScreen.getId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validScreen.getId());
	}

	@Test
	public void deleteScreen_InvalidScreen_Unsuccessful() {
		Screen invalidScreen = new Screen();
		invalidScreen.setCapacity(450L);
		invalidScreen.setId(42L);

		Mockito.when(this.repo.findById(invalidScreen.getId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteByScreenID(invalidScreen.getId());
	}

	@Test
	public void updateScreen_validScreen_UpdateScreen() {
		Screen validScreen = new Screen(3L, 200L);

		Screen updateScreen = new Screen(250L);

		Mockito.when(this.repo.findById(validScreen.getId())).thenReturn(Optional.of(validScreen));
		this.service.updateScreen(updateScreen, validScreen.getId());
		Mockito.verify(this.repo, Mockito.times(1)).save(validScreen);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validScreen.getId());

	}
}
