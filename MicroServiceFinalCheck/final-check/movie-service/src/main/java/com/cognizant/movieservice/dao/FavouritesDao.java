package com.cognizant.movieservice.dao;

import java.util.List;

import com.cognizant.movieservice.model.Movie;

public interface FavouritesDao {

	public String addToFavourites(long customerId, long movieId);

	public String addCustomer(long id);

	public String deleteFromFavourites(long customerId, long movieId);

	public List<Movie> showFavourites(long customerId);
}
