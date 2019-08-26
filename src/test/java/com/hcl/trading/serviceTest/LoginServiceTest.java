package com.hcl.trading.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.dto.LoginResponseDto;
import com.hcl.trading.entity.User;
import com.hcl.trading.exception.UserNotFoundException;
import com.hcl.trading.repository.UserRepository;
import com.hcl.trading.service.LoginServiceImpl;
import com.hcl.trading.util.PasswordUtil;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	PasswordUtil passwordUtil;
	
	User user;
	LoginDto loginDto;
	LoginResponseDto loginResponseDto;

	public User getUser() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("venkat");
		user.setPassword("password");
		user.setEmailId("abc@gmail.com");
		return user;
	}

	public LoginDto getUserLoginDto() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("venkat");
		loginDto.setPassword("admin@123");
		String password = "admin@123";
//		passwordUtil.encodePassword(loginDto.setPassword("admin@123"));
		passwordUtil.encodePassword(password);
		return loginDto;
	}

	public LoginResponseDto getLoginResponseDto()
	{
		LoginResponseDto loginResponseDto  = new LoginResponseDto();
		loginResponseDto.setMessage("login successful");
		loginResponseDto.setUserId(1);
		return loginResponseDto;
		
	}
	
	@Before
	public void setup()
	{
		user = getUser();
		loginDto = getUserLoginDto();
		loginResponseDto = getLoginResponseDto();
	}
	@Test
	public void loginUserTest() {
		user = getUser();
		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(),Mockito.anyString()))
		.thenReturn(Optional.of(user));
		LoginResponseDto response = loginServiceImpl.loginUser(loginDto);
		assertEquals("login successful", response.getMessage());
	}
	
	@Test(expected = UserNotFoundException.class)
	public void loginUserTest_1() {
		user = getUser();
	loginServiceImpl.loginUser(loginDto);
	}
	
}
