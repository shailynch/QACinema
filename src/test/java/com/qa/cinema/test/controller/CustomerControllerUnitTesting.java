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

import com.qa.cinema.controllers.CustomerController;
import com.qa.cinema.models.Customer;
import com.qa.cinema.repo.CustomerRepo;
import com.qa.cinema.service.CustomerService;

@SpringBootTest
public class CustomerControllerUnitTesting {

	@Autowired
	private CustomerController controller;

	@MockBean
	private CustomerService service;

	@MockBean
	private CustomerRepo repo;

	@Test
	public void createCustomerTest() throws Exception {
		Customer validCustomer = new Customer(1L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");

		Mockito.when(this.service.addCustomer(validCustomer)).thenReturn(validCustomer);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(validCustomer, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.addCustomer(validCustomer));
		Mockito.verify(this.service, Mockito.times(1)).addCustomer(validCustomer);
	}

	@Test
	public void getAllCustomersTest() {
		Customer validCustomer = new Customer(1L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");

		List<Customer> customers = new ArrayList<>();
		customers.add(validCustomer);

		Mockito.when(this.service.readAll()).thenReturn(customers);
		assertThat(customers).isEqualTo(controller.getAllCustomers());
		Mockito.verify(this.service, Mockito.times(1)).readAll();
	}

	@Test
	public void readCustomerByIDTest() throws Exception {
		Customer validCustomer = new Customer(1L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");

		List<Customer> customers = new ArrayList<>();
		customers.add(validCustomer);

		Mockito.when(this.service.readCustomer(validCustomer.getId())).thenReturn(customers.get(0));
		Customer value = customers.get(0);

		assertThat(value).isEqualTo(controller.getCustomerById(validCustomer.getId()));
		Mockito.verify(this.service, Mockito.times(1)).readCustomer(validCustomer.getId());

	}

	@Test
	public void updateCustomerByIdTest() {
		Customer validCustomer = new Customer(1L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");

		List<Customer> customers = new ArrayList<>();
		customers.add(validCustomer);

		Customer updateCustomer = new Customer("George", "Michael", "11/06/1990",
				"notTheOriginalGeorgeMichael@arrestedDev.com", "07884542469");

		Mockito.when(this.service.updateCustomer(updateCustomer, validCustomer.getId())).thenReturn(validCustomer);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(validCustomer, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateCustomerById(validCustomer.getId(), updateCustomer));
		Mockito.verify(this.service, Mockito.times(1)).updateCustomer(updateCustomer, validCustomer.getId());
	}

	@Test
	public void deleteCustomerById_SuccessfulTest() {
		Customer validCustomer = new Customer(1L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");
		List<Customer> customers = new ArrayList<>();
		customers.add(validCustomer);

		Mockito.when(this.service.deleteByCustomerID(validCustomer.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteCustomer(validCustomer.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByCustomerID(validCustomer.getId());
	}

	@Test
	public void deleteCustomerById_UnsuccessfullTest() {
		Customer invalidCustomer = new Customer(77L, "Bob", "Loblaw", "22/07/1976", "bobloblaw@lawblogs.com",
				"07914625530");
		List<Customer> customers = new ArrayList<>();
		customers.add(invalidCustomer);

		Mockito.when(this.service.deleteByCustomerID(invalidCustomer.getId())).thenReturn(false);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		assertThat(response).isEqualTo(controller.deleteCustomer(invalidCustomer.getId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteByCustomerID(invalidCustomer.getId());
	}

}
