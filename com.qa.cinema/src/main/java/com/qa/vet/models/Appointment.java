package com.qa.vet.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	// Name that is not null
	@Column
	private Long vetID;
	@Column
	private Long petID;
	@Column
	private Long customerID;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getVetID() {
		return vetID;
	}

	public void setVetID(Long vetID) {
		this.vetID = vetID;
	}

	public Long getPetID() {
		return petID;
	}

	public void setPetID(Long petID) {
		this.petID = petID;
	}

	@Override
	public String toString() {
		return "Appointment [Id=" + Id + ", vetID=" + vetID + ", petID=" + petID + ", customerID=" + customerID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, customerID, petID, vetID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(customerID, other.customerID)
				&& Objects.equals(petID, other.petID) && Objects.equals(vetID, other.vetID);
	}

	public Appointment() {

	}

	public Appointment(Long customerID, Long petID, Long vetID) {
		this.setCustomerID(customerID);
		this.setPetID(petID);
		this.setVetID(vetID);
	}

	public Appointment(Long id, Long customerID, Long petID, Long vetID) {
		this.setId(id);
		this.setPetID(petID);
		this.setVetID(vetID);
		this.setCustomerID(customerID);
	}

}
