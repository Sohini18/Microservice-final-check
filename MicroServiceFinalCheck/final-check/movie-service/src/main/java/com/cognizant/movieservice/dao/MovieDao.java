package com.cognizant.movieservice.dao;

import java.util.List;

import com.cognizant.movieservice.model.Movie;

public interface MovieDao {

	public List<Movie> modifyMovie(Movie movie);

	public List<Movie> CustomerMovieList();
}
