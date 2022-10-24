package org.projet.mediatheque.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemRepositoryTest {
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void findDisponiblesTest() {
		int numbre_copies = 0;
		
		List<Item> findDisponiblesResult = itemRepository.findDisponibles().get();	
		for (Item item : findDisponiblesResult) {
			if(item.getNombreExemplaire()>0) {
				numbre_copies++;
			}
		}
		
		assertNotNull(numbre_copies);
		
	}
	
	@Test
	public void findItemsByDateParutionTest() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH-1));
		Date date = cal.getTime();
		
//		date.setMonth(date.getMonth()-1);
		int numbre_copies = 0;
		
		List<Item> findItemsByDateParutionResult = itemRepository.findItemsByDateParution(date);	
		for (Item item : findItemsByDateParutionResult) {
			if(item.getNombreExemplaire()>0 && date.before(item.getDateParution())) {
				numbre_copies++;
			}
		}
		
		assertNotNull(numbre_copies);
		
	}
	

}
