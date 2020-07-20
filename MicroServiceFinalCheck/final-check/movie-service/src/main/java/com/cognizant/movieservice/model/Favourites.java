package com.cognizant.movieservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "favourites")
public class Favourites {

	@Id
	private long id;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "Customer_favourite", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private List<Movie> favourites = new ArrayList<>();

}
