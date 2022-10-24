package org.projet.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpruntServiceTest {
	
	@Autowired
	private EmpruntService empruntService;
	
	@Test
	public void findAllEmpruntesByUserIdTest() throws ItemNotFoundException {
		List<Emprunt> listEmpruntesByUserIdResult = empruntService.findAllEmpruntesByUserId(1l);
		
		assertTrue(listEmpruntesByUserIdResult.size()>0);
	}

}
