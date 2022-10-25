package org.projet.mediatheque.controller;

import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/accueil")
	public String homePage() {
		return "Bienvenue sur le site des médias !";
	}

	@GetMapping("/user/{login}")
	public ResponseEntity<User> getUserByLogin(@PathVariable String login) throws ItemNotFoundException {
		User userByLogin = userService.findUserByLogin(login);

		return new ResponseEntity<User>(userByLogin, HttpStatus.OK);
	}
}
