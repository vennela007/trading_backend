package com.hcl.trading.controllerTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.trading.controller.LoginController;
import com.hcl.trading.dto.LoginDto;
import com.hcl.trading.service.LoginServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	@Mock
	LoginServiceImpl loginServiceimpl;
	@InjectMocks
	LoginController loginController;
	MockMvc mockMvc;
	LoginDto loginDto;
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
		loginDto = new LoginDto("venkat", "venkat");
	}
	@Test
	public void userLoginTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(loginDto))).andExpect(status().isOk());
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
