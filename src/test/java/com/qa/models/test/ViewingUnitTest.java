package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Viewing;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ViewingUnitTest {

	static Viewing viewing;

	@BeforeAll
	public static void createViewing() {
		System.out.println("Creating viewing");
		viewing = new Viewing(1L, 1L, 1L, 1L, "12");
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Viewing.class)
				.withPrefabValues(Viewing.class, new Viewing(1L, 1L, 1L, "12"), new Viewing(2L, 2L, 2L, "11")).verify();
	}

	@Test
	public void testToString() {
		String expecting = "Viewing [Id=" + viewing.getId() + ", viewingID=" + viewing.getViewingID() + ", screenID="
				+ viewing.getScreenID() + ", movieID=" + viewing.getMovieID() + ", startTime=" + viewing.getStartTime()
				+ "]";
		assertEquals(expecting, viewing.toString());
	}

	@Test
	public void constructorTests() {
		Viewing viewing1 = new Viewing();
		Viewing viewing2 = new Viewing(1L, 1L, 1L, "1");
		Viewing viewing3 = new Viewing(2L, 2L, 2L, 2L, "2");

		assertTrue(viewing1 instanceof Viewing == true);
		assertTrue(viewing2 instanceof Viewing == true);
		assertTrue(viewing3 instanceof Viewing == true);
	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Viewing testViewing = new Viewing();
		testViewing.setId(5L);

		Field expected = testViewing.getClass().getDeclaredField("Id");
		expected.setAccessible(true);
		assertEquals(expected.get(testViewing), 5L);

	}

	@Test
	public void setViewingIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Viewing testViewing = new Viewing();
		testViewing.setViewingID(5L);

		Field expected = testViewing.getClass().getDeclaredField("viewingID");
		expected.setAccessible(true);
		assertEquals(expected.get(testViewing), 5L);

	}

	@Test
	public void setScreenIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Viewing testViewing = new Viewing();
		testViewing.setScreenID(5L);

		Field expected = testViewing.getClass().getDeclaredField("screenID");
		expected.setAccessible(true);
		assertEquals(expected.get(testViewing), 5L);

	}

	@Test
	public void setMovieIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Viewing testViewing = new Viewing();
		testViewing.setMovieID(5L);

		Field expected = testViewing.getClass().getDeclaredField("movieID");
		expected.setAccessible(true);
		assertEquals(expected.get(testViewing), 5L);

	}

	@Test
	public void setStartTimeTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Viewing testViewing = new Viewing();
		testViewing.setStartTime("12");

		Field expected = testViewing.getClass().getDeclaredField("startTime");
		expected.setAccessible(true);
		assertEquals(expected.get(testViewing), "12");

	}
}
