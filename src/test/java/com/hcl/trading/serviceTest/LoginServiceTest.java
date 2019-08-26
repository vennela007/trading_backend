package com.hcl.trading.serviceTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.dto.StockDto;
import com.hcl.trading.entity.User;
import com.hcl.trading.repository.UserRepository;
import com.hcl.trading.service.LoginServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
@Mock UserRepository userRepository;
@InjectMocks LoginServiceImpl loginServiceImpl; 
User user;
StockDto stockDto;
LoginDto loginDto;

public User getUser()
{
	User user = new User();
	user.setUserId(1);
	user.setUserName("venkat");
	user.setPassword("password");
	user.setEmailId("abc@gmail.com");
	return user;
}
public LoginDto getUserLoginDto()
{
	LoginDto loginDto = new LoginDto();
	loginDto.setUserName("venkat");
	loginDto.setPassword("admin@123");
	return loginDto;
}
@Test
public void loginUserTest() {
	Mockito.when(userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword())).thenReturn(java.util.Optional.of(user));
	assertEquals("login successful", loginServiceImpl.loginUser(loginDto));
}
}
