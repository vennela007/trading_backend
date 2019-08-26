package com.hcl.trading.service;
import org.springframework.stereotype.Service;
import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.dto.LoginResponseDto;
@Service
public interface LoginService {
	public LoginResponseDto loginUser(LoginDto loginDto);
}
