package org.projet.mediatheque.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findUserByLoginTest() {
		Optional<User> findUserbyLogin = userRepository.findUserByLogin("amal@email.com");				
		assertEquals("Amal",findUserbyLogin.get().getPrenom());
		
	}
	
	@Test
	public void findUserByIdTest() {
		Optional<User> findUserbyId =userRepository.findById(1l);				
		assertEquals("Amal",findUserbyId.get().getPrenom());
		
	}

}
