package org.projet.mediatheque.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmpuntRepositoryTest {
	@Autowired
	private EmpruntRepository empruntRepository;

	@Test
	public void findByUserTest() {
		User user = new User();
		user.setId(1l);
		List<Emprunt> findByUserResult = empruntRepository.findByUser(user);
		assertTrue(findByUserResult.size() > 0);

	}

	@Test
	public void findByUserIdTest() {
		List<Emprunt> findByUserIdResult = empruntRepository.findByUserId(1l);
		assertTrue(findByUserIdResult.size() > 0);

	}

}
