package com.hcl.trading.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.dto.OrderResponseDto;
import com.hcl.trading.service.OrderServcie;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class OrderController {
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderServcie orderService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/order")
	public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		logger.info("inside the controller create  order");
		return new ResponseEntity<>(orderService.createOrder(orderRequestDto), HttpStatus.CREATED);
	}

}
