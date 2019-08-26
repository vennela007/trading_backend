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

import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.dto.LoginResponseDto;
import com.hcl.trading.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class LoginController {
private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
@ Autowired LoginService loginService;
@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginDto loginDto) {
		logger.info("inside the userLogin method..");
		return new ResponseEntity<>(loginService.loginUser(loginDto), HttpStatus.OK);		
	}
}