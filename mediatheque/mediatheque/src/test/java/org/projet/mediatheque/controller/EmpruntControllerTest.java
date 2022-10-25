package org.projet.mediatheque.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class EmpruntControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void findAllEmpruntesByUserIdTest() throws Exception {
		mvc.perform(get("/emprunts/by-user/1")).andExpect(status().isOk());
	}
	
	@Test
	public void findAllEmpruntesByUserIdTest_whenUserIdNotFound_shouldReturnException() throws Exception {
		mvc.perform(get("/emprunts/by-user/1000")).andExpect(status().isNotFound());
	}
	
	@Test
	public void effectuerEmprunteTest() throws Exception {
				
		mvc.perform(post("/emprunts/emprunt/3").content()).andExpect(status().isOk());
	}
	
	@Test
	public void effectuerEmprunteTest_whenUserIdNotFound_shouldException() throws Exception {
		mvc.perform(post("/emprunts/emprunt/0/3,6")).andExpect(status().isNotFound());
	}
	
	@Test
	public void effectuerEmprunteTest_whenItemIdNotFound_shouldReturnException() throws Exception {
		mvc.perform(post("/emprunts/emprunt/3/0")).andExpect(status().isNotFound());
	}
	
	@Test
	public void effectuerEmprunteTest_whenItemNotAvailable_shouldException() throws Exception {
		mvc.perform(post("/emprunts/emprunt/3/2")).andExpect(status().isNotFound());
	}
	
	@Test
	public void effectuerEmprunteTest_whenNumberItemReached_shouldException() throws Exception {
		mvc.perform(post("/emprunts/emprunt/3/1,1,5,6")).andExpect(status().isNotFound());
	}
	
	@Test
	public void restituerEmprunteTest() throws Exception {
		mvc.perform(get("/emprunts/restituer/1")).andExpect(status().isOk());
	}
	
	@Test
	public void restituerEmprunteTest_whenItemNotFound_shouldReturnException() throws Exception {
		mvc.perform(get("/emprunts/restituer/0")).andExpect(status().isNotFound());
	}

}
