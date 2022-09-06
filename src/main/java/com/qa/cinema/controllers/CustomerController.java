package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.qa.cinema.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService service;

	@Autowired
	CustomerController(CustomerService service) {
		this.service = service;
	}

	@CrossOrigin
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return service.readAll();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return service.readCustomer(id);
	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer createCustomer = service.addCustomer(customer);
		return new ResponseEntity<Customer>(createCustomer, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
		Customer updatedCustomer = this.service.updateCustomer(customer, id);
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);

	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {

		Boolean deletedCustomer = service.deleteByCustomerID(id);

		return (deletedCustomer) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}