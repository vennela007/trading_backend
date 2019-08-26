package com.hcl.trading.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.dto.LoginResponseDto;
import com.hcl.trading.entity.User;
import com.hcl.trading.exception.UserNotFoundException;
import com.hcl.trading.repository.UserRepository;
import com.hcl.trading.util.PasswordUtil;
import com.hcl.trading.util.TradingConstants;

@Service
public class LoginServiceimpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceimpl.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordUtil passwordUtil;
	LoginResponseDto loginResponseDto;

	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		logger.info("inside the loginUser method of serviceimple");
		Optional<User> user = userRepository.findByUserNameAndPassword(loginDto.getUserName(),
				passwordUtil.encodePassword(loginDto.getPassword()));
		if (!user.isPresent())
			throw new UserNotFoundException(TradingConstants.ERROR_INVALID_CREDENTIALS);
	
		loginResponseDto=new LoginResponseDto();
		loginResponseDto.setMessage("login successful");
		loginResponseDto.setUserId(user.get().getUserId());
		return loginResponseDto;
	}

}
