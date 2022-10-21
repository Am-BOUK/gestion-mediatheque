package org.projet.mediatheque.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Console;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.entity.Emprunt;
import org.projet.mediatheque.entity.Item;
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
//		List<Emprunt> findByUserResult = empruntRepository.findByUser(null);
		List<Emprunt> findByUserResult = empruntRepository.findByUser(user);
		System.out.println("Ceci est un test : "+findByUserResult);
		assertTrue(findByUserResult.size()>0);
		
	}
	

}
