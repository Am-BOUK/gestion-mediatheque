package org.projet.mediatheque.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.projet.mediatheque.MediathequeApplication;
import org.projet.mediatheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private UserService userService;

	@Test
	public void getUserByLoginTest() throws Exception {
		mvc.perform(get("/users/user/amal@email.com"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.prenom", is("Amal")));
	}
	
	@Test
	public void getUserByLoginTest_whenLoginNotFound() throws Exception {
		mvc.perform(get("/users/user/unknown@email.com"))
		.andExpect(status().isNotFound());
	}

}
