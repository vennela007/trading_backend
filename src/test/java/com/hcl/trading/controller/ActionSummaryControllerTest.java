/*package com.hcl.trading.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.trading.service.ActionSummaryService;

@RunWith(MockitoJUnitRunner.class)
public class ActionSummaryControllerTest {
	
	@Mock
	ActionSummaryService actionSummaryService;
	@InjectMocks
	ActionSummaryController actionSummaryController;
	@Autowired
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(actionSummaryController).build();
	}
	
	@Test
	public void testGetAllActionSummary() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/{userId}",Mockito.anyInt())
				.contentType(MediaType.APPLICATION_JSON).)
		
	}
}
*/