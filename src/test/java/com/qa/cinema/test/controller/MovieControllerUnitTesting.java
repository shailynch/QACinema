
package com.qa.cinema.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cinema.models.Movie;
import com.qa.cinema.service.MovieService;

@WebMvcTest
public class MovieControllerUnitTesting {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private MovieService service;

	@Test
	public void createMovieTest() throws Exception {
		Movie testMovie = new Movie("Cool Runnings", 98, "Me", "Comedy", "10/09/1990", "PG",
				"Disney movie about bobsledding", "https://picsum.photos/200");
		String testMovieAsJSON = this.mapper.writeValueAsString(testMovie);

		Mockito.when(this.service.addMovie(testMovie)).thenReturn(testMovie);

		mvc.perform(post("/movie/add").content(testMovieAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testMovieAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).addMovie(testMovie);
	}

}
