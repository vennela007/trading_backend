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

import com.hcl.trading.dto.TrendingResponseDto;
import com.hcl.trading.service.TrendingService;

/**
 * @author DeepikaSivarajan
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class TrendingController {
	private static Logger logger = LoggerFactory.getLogger(TrendingController.class);
	@Autowired
	TrendingService trendingService;

	/**
	 * This method is intended to list trending stocks based on the count
	 * 
	 * @return TrendingResponseDto which includes stockId,stockName,count
	 */

	@GetMapping("/trending")
	public ResponseEntity<List<TrendingResponseDto>> getAllTrendingStocks() {
		List<TrendingResponseDto> response = trendingService.getAllTrendingStocks();
		logger.info("trending stocks");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
