package org.projet.mediatheque.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.User;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void findUserByLoginTest() throws ItemNotFoundException {
		User userResult = userService.findUserByLogin("amal@email.com");

		assertTrue(userResult.getPrenom().contentEquals("Amal"));
	}

	@Test
	public void findUserByLoginTest_whenUserNotFound_shouldReturnEntityNotFoundException() {
		try {
			userService.findUserByLogin("unknown@email.com");
		} catch (ItemNotFoundException e) {
			assertTrue(e instanceof ItemNotFoundException);
			assertTrue(e.getMessage().contains("unknown@email.com, not found !"));
		}
	}

}
