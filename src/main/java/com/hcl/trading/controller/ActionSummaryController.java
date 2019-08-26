package com.hcl.trading.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.ActionSummaryResponseDto;
import com.hcl.trading.service.ActionSummaryService;

/**
 * @author DeepikaSivarajan
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class ActionSummaryController {
	private static Logger logger = LoggerFactory.getLogger(ActionSummaryController.class);

	@Autowired
	ActionSummaryService actionSummaryService;

	/**
	 * This method is intended to list confirmed or cancelled orders for user
	 * 
	 * @param userId is the input request
	 * @return it returns ActionSummaryResponseDto list which includes
	 *         stockId,stockExchangeName,
	 *         stockName,stockQuantity,totalPrice,creationDate,settlementDate,stockStatus
	 */

	@GetMapping("/orders/{userId}")
	public ResponseEntity<List<ActionSummaryResponseDto>> getAllActionSummary(@PathVariable Integer userId) {
		logger.info("action summary");
		List<ActionSummaryResponseDto> response = actionSummaryService.getAllActionSummary(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
