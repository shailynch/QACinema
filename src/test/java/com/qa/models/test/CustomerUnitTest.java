package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Customer;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerUnitTest {

	static Customer customer;

	@BeforeAll
	public static void createCustomer() {
		System.out.println("Creating Customer");
		customer = new Customer(1L, "Bob", "Vance", "11-04-1882", "bob@vance.com", "0123456789");
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class)
				.withPrefabValues(Customer.class,
						new Customer("Bob", "Vance", "11-04-1882", "bob@vance.com", "0123456789"),
						new Customer("Phylis", "Vance", "12-04-1882", "bobby@vance.com", "2123456789"))
				.verify();
	}

	@Test
	public void testToString() {
		String expecting = "id:" + customer.getId() + " first name:" + customer.getFirstName() + " lastName:"
				+ customer.getLastName() + "email" + customer.getEmail();
		assertEquals(expecting, customer.toString());
	}

	@Test
	public void constructorTests() {
		Customer customer1 = new Customer();
		Customer customer2 = new Customer(1L, "Jim", "Halpert", "13-08-1987", "email@address", "0123");
		Customer customer3 = new Customer("Pam", "Halpert", "15-08-1987", "emailme@address", "0423");

		assertTrue(customer1 instanceof Customer == true);
		assertTrue(customer2 instanceof Customer == true);
		assertTrue(customer3 instanceof Customer == true);
	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setId(5L);

		Field expected = testCustomer.getClass().getDeclaredField("Id");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), 5L);

	}

	@Test
	public void setFirstNameTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setFirstName("Dwight");

		Field expected = testCustomer.getClass().getDeclaredField("firstName");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), "Dwight");

	}

	@Test
	public void setLastNameTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setLastName("Schrute");

		Field expected = testCustomer.getClass().getDeclaredField("lastName");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), "Schrute");

	}

	@Test
	public void setEmailTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setEmail("Schrute@farms");

		Field expected = testCustomer.getClass().getDeclaredField("email");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), "Schrute@farms");

	}

	@Test
	public void setDOBTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setDob("21-2-1978");

		Field expected = testCustomer.getClass().getDeclaredField("dob");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), "21-2-1978");

	}

	@Test
	public void setMobileTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Customer testCustomer = new Customer();
		testCustomer.setMobile("987456");

		Field expected = testCustomer.getClass().getDeclaredField("mobile");
		expected.setAccessible(true);
		assertEquals(expected.get(testCustomer), "987456");

	}
}
