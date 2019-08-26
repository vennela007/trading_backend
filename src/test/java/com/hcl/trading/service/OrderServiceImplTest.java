package com.hcl.trading.service;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.hcl.trading.dto.GlobalQuoteDto;
import com.hcl.trading.dto.LatestStockPriceDto;
import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.dto.OrderResponseDto;
import com.hcl.trading.entity.Orders;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.entity.User;
import com.hcl.trading.repository.LatestPriceRepository;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	
	@Mock
	OrdersRepository orderRepository;	
	
	@Mock
	StockRepository stockRepository;
	
	@Mock
	UserRepository userRepository;

	@Mock
	LatestPriceRepository latestPriceRepository;
	
	@InjectMocks
	OrderServiceImpl orderServiceImpl;
	
	@Mock
     RestTemplate restTemplate;
	
	
	OrderRequestDto orderRequestDto;
	
	OrderResponseDto orderResponseDto;
	User user;
	Stocks stock;
	Orders orders;
	LatestStockPriceDto latestStockPriceDto;
	GlobalQuoteDto globalQuoteDto;
	@Before
	public void setUp() {
		orderRequestDto=getOrderRequestDto();
		orderResponseDto=getOrderResponseDto();
		user=getUser();
		stock=getStock();
		orders=getOrders();
		latestStockPriceDto=getLatestPriceDto();
		globalQuoteDto=getGlobalQote();
	}

//	@Test()
//	public void createBookTest()
//	{
//		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
//		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
//		Mockito.when(orderRepository.save(Mockito.any())).thenReturn(orders);
//		OrderResponseDto orderResponseDto=orderServiceImpl.createOrder(orderRequestDto);
//		Mockito
//        .when(restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=GOOGL&apikey=CQA8OG03A7GVM5ZU", GlobalQuoteDto.class))
//        .thenReturn(new ResponseEntity(emp, HttpStatus.OK));
//		
////		orderServiceImpl.latestStockPrice("GOOGL");
//		Assert.assertEquals(1, 1);
//	}
	
	public OrderRequestDto getOrderRequestDto()
	{
		return new OrderRequestDto(1,1,20,"GOOGL");
	}
	
	public OrderResponseDto getOrderResponseDto()
	{
		return new OrderResponseDto(1, 100.00, 200.00);
	}
	
	public User getUser()
	{
		return new User(1, "priya", "123", "h@gmail.com");
	}
	
	public Stocks getStock()
	{
		return new Stocks(1, "NSE", "GOOGL", 1000.00, 2, 1);
	}
	public Orders getOrders()
	{
		return new Orders(1, 1, 20, 1000.00, LocalDate.now(), LocalDate.now(), "P", 1);
	}
	
	public LatestStockPriceDto getLatestPriceDto()
	{
		return new LatestStockPriceDto("GOOGL", 123.00, 123.00, 12.00, 12.00, 12, LocalDate.now(), 11.00, 11.00, "11.00");
	}
	
	public GlobalQuoteDto getGlobalQote() {
		return new GlobalQuoteDto(getLatestPriceDto());
	}
	


}
