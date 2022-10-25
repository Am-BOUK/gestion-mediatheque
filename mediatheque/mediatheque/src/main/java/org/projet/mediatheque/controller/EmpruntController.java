package org.projet.mediatheque.controller;

import java.util.List;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.exception.ItemNotAvailableException;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.exception.NumberItemReachedException;
import org.projet.mediatheque.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emprunts")
public class EmpruntController {

	@Autowired
	private EmpruntService empruntService;

	@GetMapping(value = "/by-user/{idUser}")
	public ResponseEntity<List<Emprunt>> findAllEmpruntesByUserId(@PathVariable Long idUser)
			throws ItemNotFoundException {
		List<Emprunt> empruntesListByUserId = empruntService.findAllEmpruntesByUserId(idUser);
		return new ResponseEntity<List<Emprunt>>(empruntesListByUserId, HttpStatus.OK);
	}

	@PostMapping(value = "/emprunt/{idUser}")
	public ResponseEntity<Emprunt> effectuerEmprunte(@PathVariable Long idUser, @RequestBody List<Long> idItems)
			throws ItemNotFoundException, ItemNotAvailableException, NumberItemReachedException {
		Emprunt emprunt = empruntService.effectuerEmprunte(idUser, idItems);

		return new ResponseEntity<Emprunt>(emprunt, HttpStatus.OK);
	}

	@GetMapping(value = "/restituer/{idEmprunt}")
	public ResponseEntity<Void> restituerEmprunte(@PathVariable Long idEmprunt) throws ItemNotFoundException {
		empruntService.restituerEmprunte(idEmprunt);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
