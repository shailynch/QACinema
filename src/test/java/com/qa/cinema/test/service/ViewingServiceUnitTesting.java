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

import com.qa.cinema.models.Viewing;
import com.qa.cinema.repo.ViewingRepo;
import com.qa.cinema.service.ViewingService;

@SpringBootTest
public class ViewingServiceUnitTesting {

	@Autowired
	private ViewingService service;

	@MockBean
	private ViewingRepo repo;

	@Test
	public void createViewing_ValidViewing_SaveViewing() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "18:00");

		Viewing saveViewing = new Viewing(1L, 1L, "18:00");

		Mockito.when(this.service.addViewing(saveViewing)).thenReturn(validViewing);
		assertEquals(validViewing, this.service.addViewing(saveViewing));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveViewing);
	}

	@Test
	public void updateViewing_validViewing_UpdateViewing() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "18:00");
		Viewing updateViewing = new Viewing(2L, 1L, "19:00");

		Mockito.when(this.repo.findById(validViewing.getId())).thenReturn(Optional.of(validViewing));
		this.service.updateViewing(updateViewing, validViewing.getId());

		Mockito.verify(this.repo, Mockito.times(1)).save(validViewing);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validViewing.getId());
	}

	@Test
	public void deleteViewing_Viewing_Successful() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "18:00");

		Mockito.when(this.repo.findById(validViewing.getId())).thenReturn(Optional.of(validViewing));
		this.service.deleteByViewingID(validViewing.getId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validViewing.getId());
	}

	@Test
	public void deleteViewing_InvalidViewing_Unsucessful() {
		Viewing invalidViewing = new Viewing();
		invalidViewing.setId(90L);
		invalidViewing.setStartTime("23:59");

		Mockito.when(this.repo.findById(invalidViewing.getId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteByViewingID(invalidViewing.getId());
	}

	@Test
	public void readViewings_ValidViewings_Viewings() {
		List<Viewing> viewings = new ArrayList<>();
		viewings.add(new Viewing(1L, 1L, 1L, "10:00"));
		Mockito.when(this.service.readAll()).thenReturn(viewings);
		assertEquals(viewings, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).allFromViewing();
	}

	@Test
	public void readOneViewing_ValidViewing_OneViewing() {
		Viewing validViewing = new Viewing(1L, 1L, 1L, "12:00");
		Mockito.when(this.repo.findById(validViewing.getId())).thenReturn(Optional.of(validViewing));
		assertThat(this.service.readViewing(validViewing.getId())).isEqualTo(validViewing);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validViewing.getId());
	}

}
