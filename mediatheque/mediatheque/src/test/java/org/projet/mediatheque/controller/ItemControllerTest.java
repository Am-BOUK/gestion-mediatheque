package org.projet.mediatheque.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ItemControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllAvailableItemsTest() throws Exception {
		mvc.perform(get("/items/availableItems")).andExpect(status().isOk());
	}
	
	@Test
	public void getItemsByDateParutionTest() throws Exception {
		mvc.perform(get("/items/newItems/10-10-2010")).andExpect(status().isOk());
	}

	@Disabled
	@Test
	public void getItemsByDateParutionTest_whenDateNotValid() throws Exception {
		mvc.perform(get("/items/newItems/2fev2021")).andExpect(status().is5xxServerError());
	}

}
