package com.hcl.trading.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.service.OrderServcie;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceController {
	@Mock
	OrderServcie orderService;
	@InjectMocks
	OrderController orderController;
	
	MockMvc mockMvc;
	
	OrderRequestDto orderRequestDto;
	

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
		orderRequestDto=getOrderRequestDto();
	}

	@Test
	public void createOrderTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/order").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(orderRequestDto)))
				.andExpect(status().isCreated());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	public OrderRequestDto getOrderRequestDto()
	{
		return new OrderRequestDto(1,1,20,"GOOGL");
	}

}
