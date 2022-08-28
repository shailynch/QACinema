package com.qa.vet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.vet.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	// custom queries

	@Query(value = "SELECT * FROM customer", nativeQuery = true)
	public List<Customer> allFromCustomer();

	@Query(value = "SELECT * FROM customer WHERE id = ?1", nativeQuery = true)
	public Customer findByID(Long id);

	@Query(value = "SELECT * FROM customer WHERE id = ?1", nativeQuery = true)
	public static Customer find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
