package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Screen;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ScreenUnitTest {
	static Screen screen;

	@BeforeAll
	public static void createScreen() {
		System.out.println("Creating Screen");
		screen = new Screen(1L, 200L);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Screen.class)
				.withPrefabValues(Screen.class, new Screen(1L, 200L), new Screen(2L, 220L)).verify();
	}

	@Test
	public void testToString() {
		String expecting = "Screen [Id=" + screen.getId() + ", capacity=" + screen.getCapacity() + "]";
		assertEquals(expecting, screen.toString());
	}

	@Test
	public void constructorTests() {
		Screen screen1 = new Screen();
		Screen screen2 = new Screen(220L);
		Screen screen3 = new Screen(1L, 200L);

		assertTrue(screen1 instanceof Screen == true);
		assertTrue(screen2 instanceof Screen == true);
		assertTrue(screen3 instanceof Screen == true);
	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Screen testScreen = new Screen();
		testScreen.setId(5L);

		Field expected = testScreen.getClass().getDeclaredField("Id");
		expected.setAccessible(true);
		assertEquals(expected.get(testScreen), 5L);

	}

	@Test
	public void setCapactiyTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Screen testScreen = new Screen();
		testScreen.setCapacity(200L);

		Field expected = testScreen.getClass().getDeclaredField("capacity");
		expected.setAccessible(true);
		assertEquals(expected.get(testScreen), 200L);

	}
}
