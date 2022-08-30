package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.cinema.models.Customer;
import com.qa.cinema.repo.CustomerRepo;

@Component
public class CustomerService {
	private Customer customer;
	private CustomerRepo repo;

	@Autowired
	public CustomerService(CustomerRepo repo) {
		super();
		this.customer = new Customer();
		this.repo = repo;
	}

	// create
	public Customer addCustomer(Customer newCustomer) {
		return repo.save(newCustomer);
	}

	// read
	public String readCustomer(Long id) {
		Customer customerCheck = repo.findById(id).get();
		if (customerCheck != null) {
			return customerCheck.toString();
		} else {
			return "not found";
		}
	}

	public List<Customer> readAll() {
		return repo.allFromCustomer();
		// .get returns null or the customer as the customer would be optional
		// type check would be better
	}

	// update - change to current customer and new customer
	public Customer updateCustomer(Customer updateCustomer, Long id) {
		Optional<Customer> currentCustomer = this.repo.findById(id);
		if (currentCustomer.get() instanceof Customer) {
			Customer oldCustomer = currentCustomer.get();
			oldCustomer.setFirstName(updateCustomer.getFirstName());
			oldCustomer.setLastName(updateCustomer.getLastName());
			oldCustomer.setDob(updateCustomer.getDob());
			oldCustomer.setEmail(updateCustomer.getEmail());
			oldCustomer.setMobile(updateCustomer.getMobile());

			return repo.save(oldCustomer);
		}
		return null;

	}

	// delete
	public boolean deleteByCustomerID(Long id) {
		Optional<Customer> currentCustomer = this.repo.findById(id);
		boolean isPresent = (currentCustomer.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
