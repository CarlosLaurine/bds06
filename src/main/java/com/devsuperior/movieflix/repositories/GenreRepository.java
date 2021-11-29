package com.devsuperior.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
