package com.qa.vet.test.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.vet.models.Customer;
import com.qa.vet.repo.CustomerRepo;
import com.qa.vet.service.CustomerService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
class CustomerServiceUnitTest {

	@MockBean
	private CustomerRepo repo;

	@MockBean
	private ModelMapper mapper;

	@Autowired
	CustomerService service;

	@Test
	void addCustomer() {
		Customer TEST_CUSTOMER = new Customer("firstname", "lastname", "email");

		Mockito.when(this.repo.save(Mockito.any(Customer.class))).thenReturn(TEST_CUSTOMER);

		CustomerRepo result = (CustomerRepo) repo.save(TEST_CUSTOMER);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_CUSTOMER);

		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Customer.class));
	}
}
