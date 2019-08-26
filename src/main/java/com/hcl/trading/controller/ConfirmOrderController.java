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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.ConfirmOrderRequestDto;
import com.hcl.trading.dto.ConfirmOrderResponseDto;
import com.hcl.trading.service.ConfirmOrderServiceImpl;

/**
 * @author Gurpreet Singh
 * This is the controller class for order status
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*", "*/"}, origins = {"*", "*/"})
public class ConfirmOrderController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ConfirmOrderController.class);
	
	@Autowired
	ConfirmOrderServiceImpl confirmOrderServiceImpl;
	
	@PutMapping("/action")
	public ResponseEntity<ConfirmOrderResponseDto> confirmOrder(@RequestBody ConfirmOrderRequestDto confirmOrderRequestDto)
	
	{
		LOGGER.info("in confirmOrder() method ");
		ConfirmOrderResponseDto response = confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
