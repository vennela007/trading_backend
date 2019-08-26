package com.hcl.trading.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.trading.service.OrderServcie;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceController {
	@Mock
	OrderServcie orderService;
	@InjectMocks
	OrderController orderController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

//	@Test
//	public void getBookTest() throws Exception {
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON).content(asJsonString(bookRequestDto)))
//				.andExpect(status().isCreated());
//
//	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	//public OrderResponseDto 

}
