package com.devsuperior.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
