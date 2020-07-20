package com.cognizant.movieservice.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "boxOffice")
	private String boxOffice;

	@Column(name = "active")
	private boolean active;

	@Column(name = "dateOfLaunch")
	private Date dateOfLaunch;

	@Column(name = "genre")
	private String genre;

	@Column(name = "hasTeaser")
	private boolean hasTeaser;

	@ManyToMany // (mappedBy = "favourites")
	private Set<Favourites> favourites = new HashSet<>();
}