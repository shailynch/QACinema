package com.qa.cinema.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viewing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	// Name that is not null
	@Column
	private Long screenID;
	@Column
	private Long movieID;
	@Column
	private String startTime;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Long getScreenID() {
		return screenID;
	}

	public void setScreenID(Long screenID) {
		this.screenID = screenID;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieID, screenID, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viewing other = (Viewing) obj;
		return Objects.equals(movieID, other.movieID) && Objects.equals(screenID, other.screenID)
				&& Objects.equals(startTime, other.startTime);
	}

	@Override
	public String toString() {
		return "Viewing [Id=" + Id + ", screenID=" + screenID + ", movieID=" + movieID + ", startTime=" + startTime
				+ "]";
	}

	public Viewing() {

	}

	public Viewing(Long screenID, Long movieID, String startTime) {
		this.screenID = screenID;
		this.movieID = movieID;
		this.startTime = startTime;
	}

	public Viewing(Long id, Long screenID, Long movieID, String startTime) {
		super();
		Id = id;
		this.screenID = screenID;
		this.movieID = movieID;
		this.startTime = startTime;
	}

}
