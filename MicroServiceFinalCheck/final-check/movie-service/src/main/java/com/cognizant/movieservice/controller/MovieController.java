package com.cognizant.movieservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieservice.dao.MovieDao;
import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.repository.MovieRepository;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log
@Log4j2
@RestController
@RequestMapping("/movieservice")
public class MovieController {

	@Autowired
	MovieDao movieDao;

	@Autowired
	MovieRepository movieRepository;

	@GetMapping("/adminlist")
	public List<Movie> adminMovieList() {
		log.info("START");
		log.info("END");
		return movieRepository.findAll();
	}

	@GetMapping("/customerlist")
	public List<Movie> customerMovieList() {
		log.info("START");
		log.info("END");
		return movieDao.CustomerMovieList();
	}

	@PutMapping("/adminlist")
	public List<Movie> editMovie(@RequestBody Movie movie) {
		log.info("START");
		log.info("END");
		return movieDao.modifyMovie(movie);
	}

	@GetMapping("/adminlist/{id}")
	public Movie getMovie(@PathVariable long id) {
		log.info("START");

		Optional<Movie> m = movieRepository.findById(id);
		if (m.isPresent()) {
			log.debug("Movie: {}", m);
			log.info("END");
			return m.get();
		} else {
			log.info("END");
			log.info("Movie not found");
		}
		log.info("END");
		return null;

	}
}
