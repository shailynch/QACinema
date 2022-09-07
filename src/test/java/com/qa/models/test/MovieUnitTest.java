package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Movie;

public class MovieUnitTest {

	static Movie movie;

	@BeforeAll
	public static void createMovier() {
		System.out.println("Creating Movie");
		movie = new Movie(1L, "Top Gun Maverick", 131, "Tom Cruise", "Action", "2022", "15", "planes", "real url",
				false);
	}

//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Movie.class)
//				.withPrefabValues(Movie.class,
//						new Movie("title", 90, "cast", "genre", "date", "age", "desc", "url", false),
//						new Movie("title2", 95, "cast2", "genre2", "date2", "age2", "desc2", "url2", false))
//				.verify();
//	}

	@Test
	public void testToString() {
		String expecting = "Movie [Id=" + movie.getId() + ", title=" + movie.getTitle() + ", runtime="
				+ movie.getRuntime() + ", cast=" + movie.getCast() + ", genre=" + movie.getGenre() + ", releaseDate="
				+ movie.getReleaseDate() + ", ageRating=" + movie.getAgeRating() + ", description="
				+ movie.getDescription() + ", posterUrl=" + movie.getPosterUrl() + ", newRelease="
				+ movie.getNewRelease() + "]";

		assertEquals(expecting, movie.toString());
	}

	@Test
	public void constuctorTests() {
		Movie movie1 = new Movie();
		Movie movie2 = new Movie(1L, "Top Gun Maverick", 131, "Tom Cruise", "Action", "2022", "15", "planes",
				"real url", false);
		Movie movie3 = new Movie("Top Gun Maverick", 131, "Tom Cruise", "Action", "2022", "15", "planes", "real url",
				false);

		assertTrue(movie1 instanceof Movie == true);
		assertTrue(movie2 instanceof Movie == true);
		assertTrue(movie3 instanceof Movie == true);
	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setId(5L);

		Field expected = testMovie.getClass().getDeclaredField("Id");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), 5L);

	}

	@Test
	public void setRuntimeTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setRuntime(120);

		Field expected = testMovie.getClass().getDeclaredField("runtime");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), 120);

	}

	@Test
	public void setCastTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setCast("cast");

		Field expected = testMovie.getClass().getDeclaredField("cast");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "cast");

	}

	@Test
	public void setReleaseDateTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setReleaseDate("22");

		Field expected = testMovie.getClass().getDeclaredField("releaseDate");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "22");

	}

	@Test
	public void setAgeRatingTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setAgeRating("18");

		Field expected = testMovie.getClass().getDeclaredField("ageRating");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "18");

	}

	@Test
	public void setDescriptionTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setDescription("desc");

		Field expected = testMovie.getClass().getDeclaredField("description");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "desc");

	}

	@Test
	public void setPosterUrlTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setPosterUrl("url");

		Field expected = testMovie.getClass().getDeclaredField("posterUrl");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "url");

	}

	@Test
	public void setTitleTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setTitle("title");

		Field expected = testMovie.getClass().getDeclaredField("title");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "title");

	}

	@Test
	public void setGenreTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setGenre("genre");

		Field expected = testMovie.getClass().getDeclaredField("genre");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), "genre");

	}

	@Test
	public void setNewReleaseTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Movie testMovie = new Movie();
		testMovie.setNewRelease(true);

		Field expected = testMovie.getClass().getDeclaredField("newRelease");
		expected.setAccessible(true);
		assertEquals(expected.get(testMovie), true);

	}
}
