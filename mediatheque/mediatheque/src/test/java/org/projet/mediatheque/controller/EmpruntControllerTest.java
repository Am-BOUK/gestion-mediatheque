package org.projet.mediatheque.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class EmpruntControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

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
		List<Long> idItems = new ArrayList<>();
		idItems.add(1l);
		String jsonString = objectMapper.writeValueAsString(idItems);
		mvc.perform(post("/emprunts/emprunt/3").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

	@Test
	public void effectuerEmprunteTest_whenUserIdNotFound_shouldException() throws Exception {
		List<Long> idItems = new ArrayList<>();
		idItems.add(1l);
		mvc.perform(post("/emprunts/emprunt/0")).andExpect(status().is4xxClientError());
	}

	@Test
	public void effectuerEmprunteTest_whenItemIdNotFound_shouldReturnException() throws Exception {
		List<Long> idItems = new ArrayList<>();
		idItems.add(100l);
		mvc.perform(post("/emprunts/emprunt/3")).andExpect(status().is4xxClientError());
	}

	@Test
	public void effectuerEmprunteTest_whenItemNotAvailable_shouldException() throws Exception {
		List<Long> idItems = new ArrayList<>();
		idItems.add(2l);
		mvc.perform(post("/emprunts/emprunt/3")).andExpect(status().is4xxClientError());
	}

	@Test
	public void effectuerEmprunteTest_whenNumberItemReached_shouldException() throws Exception {
		List<Long> idItems = new ArrayList<>();
		idItems.add(1l);
		idItems.add(1l);
		idItems.add(5l);
		idItems.add(6l);
		mvc.perform(post("/emprunts/emprunt/3")).andExpect(status().is4xxClientError());
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
