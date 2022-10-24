package org.projet.mediatheque.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.exception.ItemNotAvailableException;
import org.projet.mediatheque.exception.NumberItemReachedException;
import org.projet.mediatheque.repository.EmpruntRepository;
import org.projet.mediatheque.repository.ItemRepository;
import org.projet.mediatheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpruntService {
	@Autowired
	private EmpruntRepository empruntRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Lister toutes les empruntes d'un utilisateur
	 * 
	 * @throws ItemNotFoundException
	 */
	public List<Emprunt> findAllEmpruntesByUserId(long idUser) throws ItemNotFoundException {
		User userFound = userRepository.findById(idUser)
				.orElseThrow(() -> new ItemNotFoundException("utilisateur n'existe pas !"));

		return empruntRepository.findByUser(userFound);
	}

	/**
	 * Effectuer une emprunte
	 * 
	 * @throws ItemNotFoundException
	 * @throws ItemNotAvailableException
	 * @throws NumberItemReachedException
	 */
	public Emprunt effectuerEmprunte(Long idUser, List<Long> idItems)
			throws ItemNotFoundException, ItemNotAvailableException, NumberItemReachedException {
		User userFound = userRepository.findById(idUser)
				.orElseThrow(() -> new ItemNotFoundException("utilisateur n'existe pas !"));
		;
		List<Emprunt> empruntList = findAllEmpruntesByUserId(idUser);
		int countItemsEmpruntes = 0;
		for (Emprunt emprunt : empruntList) {
			countItemsEmpruntes += emprunt.getItems().size();
		}
		if (countItemsEmpruntes + idItems.size() > 3) {
			throw new NumberItemReachedException("Vous ne pouvez pas emprunter plus de 3 fois !");
		}

		for (Long idItem : idItems) {
			Item itemFound = itemRepository.findById(idItem)
					.orElseThrow(() -> new ItemNotFoundException("item n'existe pas !"));

			if (itemFound.getNombreExemplaire() == 0) {
				throw new ItemNotAvailableException("item n'est pas disponible !");
			}

		}
		Date dateEmprunt = new Date();

		Emprunt newEmprunt = new Emprunt();
		newEmprunt.setDateEmprunt(dateEmprunt);
//		newEmprunt.setDateRetour(dateRetour);
		newEmprunt.setUser(userFound);
		for (Long idItem : idItems) {
			Item itemFound = itemRepository.findById(idItem)
					.orElseThrow(() -> new ItemNotFoundException("item n'existe pas !"));
			newEmprunt.getItems().add(itemFound);
			itemFound.setNombreExemplaire(itemFound.getNombreExemplaire() - 1);
			itemRepository.save(itemFound);
		}

		return empruntRepository.save(newEmprunt);

	}

	/**
	 * Restituer une emprunte
	 * 
	 * @throws ItemNotFoundException
	 */
	public void restituerEmprunte(Long idEmprunt) throws ItemNotFoundException {

		Emprunt empruntFound = empruntRepository.findById(idEmprunt)
				.orElseThrow(() -> new ItemNotFoundException("Emprunt n'existe pas !"));

		for (Item item : empruntFound.getItems()) {
//			Long idItem = item.getId();
			Date retourDate = new Date();
			empruntFound.setDateRetour(retourDate);
//			empruntRepository.deleteById(idItem);
//			Calendar cal = Calendar.getInstance();
//			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH + 7));
//			Date dateRetour = cal.getTime();
			if (retourDate.getDay() - empruntFound.getDateEmprunt().getDate() > 7) {
				System.out.println("Attention, vous avez dépassé la date à retourner l'item !");
			}
			item.setNombreExemplaire(item.getNombreExemplaire() + 1);
			itemRepository.save(item);
		}

	}
}
