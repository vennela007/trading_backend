package com.hcl.trading.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(NoMoviePresentException.class)
//	public ResponseEntity<ErrorResponse> noMovieFoundException(Exception e) {
//		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
//				HttpStatus.NOT_FOUND);
//	}

}
