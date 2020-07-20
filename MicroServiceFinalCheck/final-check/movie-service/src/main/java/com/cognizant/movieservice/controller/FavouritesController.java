package com.cognizant.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieservice.dao.FavouritesDao;
import com.cognizant.movieservice.model.Movie;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/movieservice")
public class FavouritesController {

	@Autowired
	FavouritesDao favouritesDao;

	@PostMapping("/favourites/{customerId}/{movieId}")
	public String addToFavourites(@PathVariable("customerId") long customerId, @PathVariable("movieId") long movieId) {
		log.info("START");
		log.info("END");
		return favouritesDao.addToFavourites(customerId, movieId);
	}

	@PostMapping("/favourites/{id}")
	public String addCustomer(@PathVariable long id) {
		log.info("START");
		log.info("END");
		return favouritesDao.addCustomer(id);
	}

	@DeleteMapping("/delete/{customerId}/{movieId}")
	public String deleteFromFavourites(@PathVariable("customerId") long customerId,
			@PathVariable("movieId") long movieId) {
		log.info("START");
		log.info("END");
		return favouritesDao.deleteFromFavourites(customerId, movieId);
	}

	@GetMapping("/favourites/{id}")
	public List<Movie> showFavourites(@PathVariable long id) {
		log.info("START");
		log.info("END");
		return favouritesDao.showFavourites(id);
	}

}
