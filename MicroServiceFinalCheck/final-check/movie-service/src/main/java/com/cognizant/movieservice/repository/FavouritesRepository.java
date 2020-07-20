package com.cognizant.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.movieservice.model.Favourites;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

}
