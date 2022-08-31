package com.qa.cinema.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
