package org.projet.mediatheque.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Get all available Items
	 * 
	 * @throws ItemNotFoundException
	 */
	public List<Item> getAllAvailableItems() throws ItemNotFoundException {
		List<Item> getAllAvailableItems = itemRepository.findDisponibles()
				.orElseThrow(() -> new ItemNotFoundException("La liste des items disponible est vide !"));
		return getAllAvailableItems;

	}

	/**
	 * Get Items By Date of Parution
	 * 
	 * @throws ItemNotFoundException
	 */
	public List<Item> getItemsByDateParution(String dateStg) throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStg);

		return itemRepository.findItemsByDateParution(date);

	}

}
