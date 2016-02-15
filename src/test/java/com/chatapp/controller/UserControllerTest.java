package com.chatapp.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.chatapp.ChatServerApplicationTests;
@WebIntegrationTest
public class UserControllerTest extends ChatServerApplicationTests {

	  private MockMvc mockMvc;
	    
	    @Autowired
	    private WebApplicationContext webApplicationContext;
	    @Before
	    public void setup() throws Exception {
	        this.mockMvc =MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }

	    @Test
		public final void login() throws Exception {
	    	mockMvc.perform(post("/chatapp/login/jsmith")).andExpect(status().isOk())
			.andExpect(content().string(containsString("123654789")));
		}
	    
	    @Test
		public final void logout() throws Exception {
	    	mockMvc.perform(post("/chatapp/logout/123654789")).andExpect(status().isOk());
		}
}
