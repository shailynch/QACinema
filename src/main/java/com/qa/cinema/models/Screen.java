package com.qa.cinema.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	// Name that is not null
	@Column
	private Long capacity;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Objects.equals(capacity, other.capacity);
	}

	@Override
	public String toString() {
		return "Screen [Id=" + Id + ", capacity=" + capacity + "]";
	}

	public Screen() {

	}

	public Screen(Long capacity) {
		this.capacity = capacity;
	}

	public Screen(Long id, Long capacity) {
		super();
		Id = id;
		this.capacity = capacity;
	}

}
