import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.trading.controller.ConfirmOrderController;
import com.hcl.trading.dto.ConfirmOrderRequestDto;
import com.hcl.trading.service.ConfirmOrderServiceImpl;

/**
 * 
 */

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ConfirmOrderControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(ConfirmOrderControllerTest.class);

	private MockMvc mockMvc;
	
	@InjectMocks
	ConfirmOrderController confirmOrderController;
	
	@Mock
	ConfirmOrderServiceImpl confirmOrderServiceImpl;
	
	ConfirmOrderRequestDto confirmOrderRequestDto;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(confirmOrderController).build();
	}

	@Test
	public void testConfirmOrder() throws Exception {
		logger.info("inside the testConfirmOrder() method");
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/action").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(confirmOrderRequestDto)))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
