package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.Customer;
import com.qa.cinema.repo.CustomerRepo;
import com.qa.cinema.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService service;

	@Autowired
	CustomerController(CustomerService service) {
		this.service = service;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/all")
	List<Customer> all() {
		return service.readAll();

	}

	@CrossOrigin
	@PostMapping("/add")
	public String newCustomerForm(@RequestBody Customer customer) {
		Customer newCustomer = customer;
		service.addCustomer(newCustomer);
		return customer.toString();
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public String updateCustomerForm(@PathVariable Long id, @RequestBody Customer customer) {
		Customer existing;
		try {
			existing = CustomerRepo.find(id);
			existing.setFirstName(customer.getFirstName());
			existing.setLastName(customer.getLastName());
			existing.setEmail(customer.getDob());
			existing.setEmail(customer.getEmail());
			existing.setEmail(customer.getMobile());
			service.updateCustomer(existing, id);

			return customer.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Customer newCustomer = customer;
			service.addCustomer(newCustomer);
			return customer.toString();
		}

	}

	@GetMapping("/{id}")
	String one(@PathVariable Long id) {

		return service.readCustomer(id);
//      .orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	void deleteCustomer(@PathVariable Long id) {
		service.deleteByCustomerID(id);
	}
}