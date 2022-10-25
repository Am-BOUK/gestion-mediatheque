package org.projet.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Item;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceTest {
	@Autowired
	private ItemService itemService;

	@Test
	public void getAllAvailableItemsTest() throws ItemNotFoundException {
		List<Item> availableItemsResult = itemService.getAllAvailableItems();
		assertNotNull(availableItemsResult.size());
	}

	@Test
	public void getItemsByDateParutionTest() throws ParseException {
		List<Item> getNewItemsResult = itemService.getItemsByDateParution("10-10-2021");
		assertNotNull(getNewItemsResult.size());
	}

	@Test
	public void getItemsByDateParutionTest_whenDateNotValid() {
		try {
			itemService.getItemsByDateParution("2001-10-10");
		} catch (ParseException e) {
			assertTrue(e instanceof ParseException);
			assertTrue(e.getMessage().contains("Veuillez entrer une date valide sous forme : dd-MM-yyyy !"));
		}
	}

}
