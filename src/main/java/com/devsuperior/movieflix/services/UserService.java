package com.devsuperior.movieflix.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.model.User;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public UserDTO getProfile() {
		User entity = authService.authenticated();
		return new UserDTO(repository.findByEmail(entity.getEmail()));
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		if (user == null) {
			logger.error("Usuario não foi encontrado para o seguinte E-Mail -> " + email);
			throw new UsernameNotFoundException("User not found");
		}
		logger.info("Usuario encontrado para o seguinte E-Mail -> " + email);
		return user;
	}
}