package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.dtos.ReviewDTO;
import com.devsuperior.movieflix.model.Movie;
import com.devsuperior.movieflix.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query("SELECT new com.devsuperior.movieflix.dtos.ReviewDTO(obj) FROM Review obj INNER JOIN obj.movie movie WHERE m = :movie")
	List<ReviewDTO> findReviewsByMovie(Movie movie);
}