package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.model.Genre;
import com.devsuperior.movieflix.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre genre "
			+ " WHERE (COALESCE(:genres) IS NULL OR genre IN :genres) ORDER BY obj.title")
	Page<Movie> find(List<Genre> genres, Pageable pageable);

}