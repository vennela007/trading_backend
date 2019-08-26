package com.hcl.trading.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.trading.dto.GlobalQuoteDto;
import com.hcl.trading.dto.LatestStockPriceDto;
import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.dto.OrderResponseDto;
import com.hcl.trading.service.OrderServcie;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class OrderController {
	private static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderServcie orderService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/order")
	public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		LOGGER.info("inside the controller create  order");
		return new ResponseEntity<>(orderService.createOrder(orderRequestDto), HttpStatus.CREATED);
	}

	@GetMapping("/latestPrice")
	private ResponseEntity<GlobalQuoteDto> latestStockPrice() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return new ResponseEntity<GlobalQuoteDto>(restTemplate
				.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=GOOGL&apikey=CQA8OG03A7GVM5ZU", HttpMethod.GET, entity, GlobalQuoteDto.class)
				.getBody(),HttpStatus.OK);
		
		

	}
}
