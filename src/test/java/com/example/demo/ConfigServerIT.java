package com.example.demo;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("git")
@AutoConfigureMockMvc
public class ConfigServerIT {

	@Autowired
	private MockMvc mvc;


	@Test
	public void whenGetResourceWithExtension_thenIsOk() throws Exception
	{
		this.mvc.perform(get("/config/default/master/file.txt"))
				.andExpect(status().isOk())
				.andExpect(content().string("hello\n"))
				.andReturn();
	}

	@Test
	public void whenGetResourceWithoutExtension_thenIsOk() throws Exception
	{
		this.mvc.perform(get("/config/default/master/file"))
				.andExpect(status().isOk())
				.andExpect(content().string("hello\n"))
				.andReturn();
	}

}
