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
		Optional<User> userFound = userRepository.findUserByLogin(login);
		if (userFound.isEmpty()) {
			System.out.println("l'utilisateur " + login + ", n'existe pas !");
			throw new ItemNotFoundException(login + ", not found !");
		} else {
			return userFound.get();
		}
	}

}
