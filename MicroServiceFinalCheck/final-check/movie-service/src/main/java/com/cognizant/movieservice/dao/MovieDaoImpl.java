package com.cognizant.movieservice.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.repository.MovieRepository;
import com.cognizant.movieservice.util.DateUtil;

import lombok.extern.java.Log;

@Component
@Log
public class MovieDaoImpl implements MovieDao {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<Movie> modifyMovie(Movie movie) {
		log.info("START");
		List<Movie> list = movieRepository.findAll();
		for (Movie mv : list) {
			if (movie.getId() == mv.getId()) {
				mv.setTitle(movie.getTitle());
				mv.setActive(movie.isActive());
				mv.setBoxOffice(movie.getBoxOffice());
				mv.setDateOfLaunch(movie.getDateOfLaunch());
				mv.setGenre(movie.getGenre());
				mv.setHasTeaser(movie.isHasTeaser());
				movieRepository.save(mv);
				log.info("END");
				break;
			}
		}
		return list;
	}

	@Override
	public List<Movie> CustomerMovieList() {
		log.info("START");
		List<Movie> list = new ArrayList<Movie>();
		List<Movie> customerList = new ArrayList<Movie>();
		LocalDateTime localDateTime = LocalDateTime.now();
		String format = DateTimeFormatter.ofPattern("dd/mm/yyyy", Locale.ENGLISH).format(localDateTime);
		Date currentSystemDate = DateUtil.convertToDate(format);
		list = movieRepository.findAll();
		for (Movie mv : list) {
			if ((mv.isActive() == true) && (mv.getDateOfLaunch().compareTo(currentSystemDate) < 0)) {
				customerList.add(mv);

			}
		}
		log.info("END");
		return customerList;
	}

}
