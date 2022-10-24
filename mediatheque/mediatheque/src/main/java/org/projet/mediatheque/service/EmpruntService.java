package org.projet.mediatheque.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.exception.EntityNotFoundException;
import org.projet.mediatheque.exception.ItemNotAvailableException;
import org.projet.mediatheque.exception.NumberItemReachedException;
import org.projet.mediatheque.repository.EmpruntRepository;
import org.projet.mediatheque.repository.ItemRepository;
import org.projet.mediatheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpruntService {
	@Autowired
	private EmpruntRepository empruntRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Effectuer une emprunte
	 * 
	 * @throws EntityNotFoundException
	 * @throws ItemNotAvailableException
	 * @throws NumberItemReachedException
	 */
	public Emprunt effectuerEmprunte(long idUser, List<Long> idItems)
			throws EntityNotFoundException, ItemNotAvailableException, NumberItemReachedException {

		Optional<User> userFound = userRepository.findById(idUser);
		if (userFound.isEmpty()) {
			throw new EntityNotFoundException("utilisateur n'existe pas !");
		}
		List<Emprunt> empruntList = empruntRepository.findByUser(userFound.get());
		if (empruntList.size() > 2) {
			throw new NumberItemReachedException("Vous ne pouvez pas emprunter plus de 3 fois !");
		}
		for (Long idItem : idItems) {
			Optional<Item> itemFound = itemRepository.findById(idItem);
			if (itemFound.isEmpty()) {
				throw new EntityNotFoundException("item n'existe pas !");
			}
			if (itemFound.get().getNombreExemplaire() == 0) {
				throw new ItemNotAvailableException("item n'est pas disponible !");
			}

			Date dateEmprunt = new Date();
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH + 7));
			Date dateRetour = cal.getTime();

			Emprunt newEmprunt = new Emprunt();
			newEmprunt.setDateEmprunt(dateEmprunt);
			newEmprunt.setDateRetour(dateRetour);
			newEmprunt.setUser(userFound.get());
			newEmprunt.getItems().add(itemFound.get());

			itemFound.get().setNombreExemplaire(itemFound.get().getNombreExemplaire() - 1);

			empruntRepository.save(newEmprunt);
			itemRepository.save(itemFound.get());

		}
		return null;

	}

}
