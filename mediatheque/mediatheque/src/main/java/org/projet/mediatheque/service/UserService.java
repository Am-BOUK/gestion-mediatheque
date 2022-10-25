package org.projet.mediatheque.service;

import java.util.Optional;

import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findUserByLogin(String login) throws ItemNotFoundException {
		User userFound = userRepository.findUserByLogin(login)
				.orElseThrow(() -> new ItemNotFoundException("User n'existe pas !"));
		return userFound;

	}

}
