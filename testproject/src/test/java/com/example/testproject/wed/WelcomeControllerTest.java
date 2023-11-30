package com.example.testproject.wed;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ConditionalOnNotWebApplication
public class WelcomeControllerTest {

	private MockMvc mockMVC;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {

		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testWelcome() throws Exception {

		mockMVC.perform(get("/")).andExpect(status().isOk());
	}
}