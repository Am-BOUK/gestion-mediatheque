package org.projet.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.exception.ItemNotAvailableException;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.projet.mediatheque.exception.NumberItemReachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpruntServiceTest {

	@Autowired
	private EmpruntService empruntService;

	@Test
	public void findAllEmpruntesByUserIdTest() throws ItemNotFoundException {
		List<Emprunt> listEmpruntesByUserIdResult = empruntService.findAllEmpruntesByUserId(1l);

		assertTrue(listEmpruntesByUserIdResult.size() > 0);
	}

	@Test
	public void findAllEmpruntesByUserIdTest_whenUserIdNotFound_shouldReturnException() {
		try {
			empruntService.findAllEmpruntesByUserId(999l);
		} catch (ItemNotFoundException e) {
			assertTrue(e instanceof ItemNotFoundException);
			assertTrue(e.getMessage().contains("utilisateur n'existe pas !"));
		}
	}

	@Test
	public void effectuerEmprunteTest()
			throws ItemNotFoundException, ItemNotAvailableException, NumberItemReachedException {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(3l);

		Emprunt faireEmprunt = empruntService.effectuerEmprunte(3l, ids);

		assertNotNull(faireEmprunt.getId());
	}

	@Test
	public void effectuerEmprunteTest_whenUserIdNotFound_shouldException()
			throws ItemNotAvailableException, NumberItemReachedException {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(3l);

		try {
			empruntService.effectuerEmprunte(0l, ids);
		} catch (ItemNotFoundException e) {
			assertTrue(e instanceof ItemNotFoundException);
			assertTrue(e.getMessage().contains("utilisateur n'existe pas !"));
		}
	}

	@Test
	public void effectuerEmprunteTest_whenItemIdNotFound_shouldReturnException()
			throws ItemNotAvailableException, NumberItemReachedException {
		List<Long> ids = new ArrayList<Long>();
		ids.add(0l);

		try {
			empruntService.effectuerEmprunte(1l, ids);
		} catch (ItemNotFoundException e) {
			assertTrue(e instanceof ItemNotFoundException);
			assertTrue(e.getMessage().contains("item n'existe pas !"));
		}
	}

	@Disabled
	@Test
	public void effectuerEmprunteTest_whenNotAvailable_shouldException()
			throws ItemNotFoundException, NumberItemReachedException {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);

		try {
			empruntService.effectuerEmprunte(3l, ids);
		} catch (ItemNotAvailableException e) {
			assertTrue(e instanceof ItemNotAvailableException);
			assertTrue(e.getMessage().contains("item n'est pas disponible !"));
		} 

	}
	
	@Test
	public void effectuerEmprunteTest_whenNumberItemReached_shouldException()
			throws ItemNotFoundException, ItemNotAvailableException  {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(1l);
		ids.add(1l);
		ids.add(1l);

		try {
			empruntService.effectuerEmprunte(3l, ids);
		} catch (NumberItemReachedException e) {
			assertTrue(e instanceof NumberItemReachedException);
			assertTrue(e.getMessage().contains("Vous ne pouvez pas emprunter plus de 3 fois "));
		} 

	}

}
