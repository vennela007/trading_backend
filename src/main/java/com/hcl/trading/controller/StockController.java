package com.hcl.trading.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.trading.dto.StockDto;
import com.hcl.trading.service.StockService;

/**
 * @author Venkat
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class StockController {
	@Autowired StockService stockService;
private static final Logger logger = LoggerFactory.getLogger(StockController.class);

@GetMapping("/getAllStocks")
	public ResponseEntity<List<StockDto>> getAllStocks(){
	/*
	 * this method is to get all available Stocks list
	 * */
		logger.info("inside the controller getMoviesList method");
		List<StockDto> response = stockService.getAllAvailableStocks();
		return  new ResponseEntity<>(response , HttpStatus.OK);
	}
}
