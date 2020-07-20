package com.cognizant.movieservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.movieservice.model.Favourites;
import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.repository.FavouritesRepository;
import com.cognizant.movieservice.repository.MovieRepository;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j2
@Log
@Component
public class FavouritesDaoImpl implements FavouritesDao {

	@Autowired
	FavouritesRepository favouritesRepository;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public String addToFavourites(long customerId, long movieId) {
		log.info("START");
		Optional<Favourites> custId = favouritesRepository.findById(customerId);
		if (custId.isPresent()) {
			Optional<Movie> mvId = movieRepository.findById(movieId);
			if (mvId.isPresent()) {
				Favourites favourites = custId.get();
				Movie movie = mvId.get();
				List<Movie> favList = favourites.getFavourites();
				favList.add(movie);
				favouritesRepository.save(favourites);
				log.info("END");
				return "Added Successfully";
			} else {
				log.info("END");
				return "Movie is not present";
			}
		}
		log.info("END");
		return "Customer is not present";
	}

	@Override
	public String addCustomer(long id) {
		log.info("START");
		Optional<Favourites> custId = favouritesRepository.findById(id);
		if (!custId.isPresent()) {
			Favourites favourites = new Favourites();
			favourites.setId(id);
			favouritesRepository.save(favourites);
			log.info("END");
			return "Customer has been successfully added";
		} else {
			log.info("END");
			return "Customer already exists";
		}
	}

	@Override
	public String deleteFromFavourites(long customerId, long movieId) {
		log.info("START");
		Optional<Favourites> custId = favouritesRepository.findById(customerId);
		if (custId.isPresent()) {
			Optional<Movie> mvId = movieRepository.findById(movieId);
			if (mvId.isPresent()) {
				Favourites favourites = custId.get();
				Movie movie = mvId.get();
				List<Movie> favList = favourites.getFavourites();
				favList.remove(movie);
				favouritesRepository.save(favourites);
				log.info("END");
				return "Deleted Successfully";
			} else {
				log.info("END");
				return "Movie is not present";
			}
		}
		log.info("END");
		return "Customer is not present";
	}

	@Override
	public List<Movie> showFavourites(long customerId) {
		log.info("START");
		Optional<Favourites> custId = favouritesRepository.findById(customerId);
		if (custId.isPresent()) {
			Favourites favourites = custId.get();
			log.info("END");
			return favourites.getFavourites();
		}
		log.info("Customer not found");
		log.info("END");
		return null;

	}

}
