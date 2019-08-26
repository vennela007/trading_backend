package com.hcl.trading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> noUserFoundException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
		
		@ExceptionHandler(OrdersNotFoundException.class)
	public ResponseEntity<ErrorResponse> ordersNotFoundException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StocksNotFoundException.class)
	public ResponseEntity<ErrorResponse> stocksNotFoundException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}
