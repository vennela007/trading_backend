package com.hcl.trading.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.trading.service.ActionSummaryService;
/**
 * 
 * @author DeepikaSivarajan
 *
 */
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
	public void testGetAllActionSummary() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/{userId}", 1).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}