package com.example.demo;
import org.junit.jupiter.api.Test;	// {1}
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.Controller.AppController;

@ExtendWith(SpringExtension.class)	// {2}
@WebMvcTest(controllers = AppController.class)	// {3}
public class SpringTest {

	@Autowired	// {4}
	private MockMvc mvc;	// {5}
	
	@Test
	public void hello_to_return() throws Exception {
		String hello = "Hello World!";
		mvc.perform(get("/"))		// {6}
				.andExpect(status().isOk())		// {7}
				.andExpect(content().string(hello));	//{8}
	}
}