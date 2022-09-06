package com.qa.cinema.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	// Title that is not null
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private int runtime;
	@Column(nullable = false)
	private String cast;
	@Column(nullable = false)
	private String genre;
	@Column
	private String releaseDate;
	@Column
	private String ageRating;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String posterUrl;
	@Column
	private Boolean newRelease = false;

	public Long getId() {
		return Id;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getNewRelease() {
		return newRelease;
	}

	public void setNewRelease(Boolean newRelease) {
		this.newRelease = newRelease;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", title=" + title + ", runtime=" + runtime + ", cast=" + cast + ", genre=" + genre
				+ ", releaseDate=" + releaseDate + ", ageRating=" + ageRating + ", description=" + description
				+ ", posterUrl=" + posterUrl + ", newRelease=" + newRelease + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, ageRating, cast, description, genre, newRelease, posterUrl, releaseDate, runtime,
				title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(ageRating, other.ageRating)
				&& Objects.equals(cast, other.cast) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && Objects.equals(newRelease, other.newRelease)
				&& Objects.equals(posterUrl, other.posterUrl) && Objects.equals(releaseDate, other.releaseDate)
				&& runtime == other.runtime && Objects.equals(title, other.title);
	}

	public Movie() {

	}

	public Movie(String title, int runtime, String cast, String genre, String releaseDate, String ageRating,
			String description, String posterUrl, Boolean newRelease) {
		super();
		this.title = title;
		this.runtime = runtime;
		this.cast = cast;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.ageRating = ageRating;
		this.description = description;
		this.posterUrl = posterUrl;
		this.newRelease = newRelease;
	}

	public Movie(Long id, String title, int runtime, String cast, String genre, String releaseDate, String ageRating,
			String description, String posterUrl, Boolean newRelease) {
		super();
		Id = id;
		this.title = title;
		this.runtime = runtime;
		this.cast = cast;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.ageRating = ageRating;
		this.description = description;
		this.posterUrl = posterUrl;
		this.newRelease = newRelease;
	}

}
