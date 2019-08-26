/**
 * 
 */
package com.hcl.trading.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.OrderStatusRequestDto;
import com.hcl.trading.dto.OrderStatusResponseDto;
import com.hcl.trading.service.OrderStatusServiceImpl;

/**
 * @author Gurpreet Singh
 * This is the controller class for order status
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*", "*/"}, origins = {"*", "*/"})
public class OrderStatusController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(OrderStatusController.class);
	
	@Autowired
	OrderStatusServiceImpl orderStatusServiceImpl;
	
	@PutMapping("/action")
	public ResponseEntity<OrderStatusResponseDto> confirmOrder(OrderStatusRequestDto orderStatusRequestDto)
	{
		LOGGER.info("in confirmOrder() method ");
		OrderStatusResponseDto response = orderStatusServiceImpl.confirmOrder(orderStatusRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
