package org.projet.mediatheque.controller;

import java.text.ParseException;
import java.util.List;

import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping(value = "/acceuil")
	public ResponseEntity<String> homePage() {
		String message = "Bienvenue depuis items page !";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/availableItems")
	public ResponseEntity<List<Item>> getAllAvailableItems() throws ItemNotFoundException{
		List<Item> getAllAvailableItems = itemService.getAllAvailableItems();
		return new ResponseEntity<List<Item>>(getAllAvailableItems, HttpStatus.OK);
	}
	
	@GetMapping(value = "/newItems/{dateStg}")
	public ResponseEntity<List<Item>> getItemsByDateParution(@PathVariable String dateStg) throws ParseException {
		List<Item> getAllNewItems = itemService.getItemsByDateParution(dateStg);
		return new ResponseEntity<List<Item>>(getAllNewItems, HttpStatus.OK);
	}
	

}
