package com.qa.cinema.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	// Name that is not null
	@Column
	private Long viewingID;
	@Column
	private String bookingDate;
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

	public Long getViewingID() {
		return viewingID;
	}

	public void setViewingID(Long viewingID) {
		this.viewingID = viewingID;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Appointment [Id=" + Id + ", viewingID=" + viewingID + ", bookingDate=" + bookingDate + ", customerID="
				+ customerID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, customerID, bookingDate, viewingID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(customerID, other.customerID)
				&& Objects.equals(bookingDate, other.bookingDate) && Objects.equals(viewingID, other.viewingID);
	}

	public Booking() {

	}

	public Booking(Long customerID, String bookingDate, Long viewingID) {
		this.setCustomerID(customerID);
		this.setBookingDate(bookingDate);
		this.setViewingID(viewingID);
	}

	public Booking(Long id, Long customerID, String bookingDate, Long viewingID) {
		this.setId(id);
		this.setBookingDate(bookingDate);
		this.setViewingID(viewingID);
		this.setCustomerID(customerID);
	}

}
