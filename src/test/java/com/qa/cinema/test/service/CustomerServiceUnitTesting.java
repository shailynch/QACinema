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

import com.qa.cinema.models.Customer;
import com.qa.cinema.repo.CustomerRepo;
import com.qa.cinema.service.CustomerService;

@SpringBootTest
public class CustomerServiceUnitTesting {

	@Autowired
	private CustomerService service;

	@MockBean
	private CustomerRepo repo;

	@Test
	public void createCustomer_ValidCustomer_SaveCustomer() {
		Customer validCustomer = new Customer(1L, "Barry", "Manilow", "28/04/1943", "barryM@mandy.com", "07123467521");

		Customer saveCustomer = new Customer("Barry", "Manilow", "28/04/1943", "barryM@mandy.com", "07123467521");

		Mockito.when(this.service.addCustomer(saveCustomer)).thenReturn(validCustomer);
		assertEquals(validCustomer, this.service.addCustomer(saveCustomer));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveCustomer);

	}

	@Test
	public void readCustomer_ValidCustomers_Customers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "Barry", "Manilow", "28/04/1943", "barryM@mandy.com", "07123467521"));

		Mockito.when(this.service.readAll()).thenReturn(customers);
		assertEquals(customers, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).allFromCustomer();
	}

	@Test
	public void readOneCustomer_ValidCustomer_OneCustomer() {
		Customer validCustomer = new Customer(1L, "Barry", "Manilow", "28/04/1943", "barryM@mandy.com", "07123467521");

		Mockito.when(this.repo.findById(validCustomer.getId())).thenReturn(Optional.of(validCustomer));
		assertThat(this.service.readCustomer(validCustomer.getId())).isEqualTo(validCustomer);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validCustomer.getId());
	}

	@Test
	public void updateCustomer_ValidCustomer_UpdatedCustomer() {
		Customer originalCustomer = new Customer(1L, "Barry", "Manilow", "28/04/1943", "barryM@mandy.com",
				"07123467521");

		Customer updatedCustomer = new Customer("Cliff", "Richard", "25/12/1920", "mistletoe@wine.com", "07111111111");

		Mockito.when(this.repo.findById(originalCustomer.getId())).thenReturn(Optional.of(originalCustomer));
		this.service.updateCustomer(updatedCustomer, originalCustomer.getId());

		Mockito.verify(this.repo, Mockito.times(1)).save(originalCustomer);
		Mockito.verify(this.repo, Mockito.times(1)).findById(originalCustomer.getId());

	}

	@Test
	public void deleteCustomer_Customer() {
		Customer validCustomer = new Customer(1L, "Barry", "Manilow", "28/04/1943", "barryM@mandy.com", "07123467521");

		Mockito.when(this.repo.findById(validCustomer.getId())).thenReturn(Optional.of(validCustomer));
		this.service.deleteByCustomerID(validCustomer.getId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validCustomer.getId());
	}

	@Test
	public void deleteCustomer_InvalidCustomer_Unsuccessful() {
		Customer invalidCustomer = new Customer();
		invalidCustomer.setId(87L);
		invalidCustomer.setFirstName("Bobby");
		invalidCustomer.setLastName("Zamora");

		Mockito.when(this.repo.findById(invalidCustomer.getId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteByCustomerID(invalidCustomer.getId());
	}

}
