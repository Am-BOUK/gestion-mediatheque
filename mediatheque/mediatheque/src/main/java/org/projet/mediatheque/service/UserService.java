package org.projet.mediatheque.service;

import java.util.List;
import java.util.Optional;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.repository.EmpruntRepository;
import org.projet.mediatheque.repository.ItemRepository;
import org.projet.mediatheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findUserByLogin(String login) throws Exception {
		Optional<User> userFound = userRepository.findUserByLogin(login);
		if (userFound.isEmpty()) {
			System.out.println("l'utilisateur " + login + ", n'existe pas !");
			throw new Exception(login + ", not found !");
		} else {
			return userFound.get();
		}
	}

}
