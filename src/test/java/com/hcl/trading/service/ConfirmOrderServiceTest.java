/**
 * 
 */
package com.hcl.trading.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trading.dto.ConfirmOrderRequestDto;
import com.hcl.trading.dto.ConfirmOrderResponseDto;
import com.hcl.trading.dto.OrderDto;
import com.hcl.trading.entity.Orders;
import com.hcl.trading.entity.StockStatus;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.entity.User;
import com.hcl.trading.exception.OrderNotFoundException;
import com.hcl.trading.exception.StocksNotFoundException;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.repository.UserRepository;

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ConfirmOrderServiceTest {
	
	@InjectMocks
	ConfirmOrderServiceImpl confirmOrderServiceImpl;
	
	@Mock
	StockRepository stockRepository;
	
	@Mock
	OrdersRepository ordersRepository;
	
	@Mock
	UserRepository userRepository;
	
	ConfirmOrderResponseDto confirmOrderResponseDto;
	ConfirmOrderRequestDto confirmOrderRequestDto;
	Stocks stock;
	User user;
	Orders order;
	OrderDto orderDto;
	
	public ConfirmOrderResponseDto getConfirmOrderResponseDto()
	{
		ConfirmOrderResponseDto confirmOrderResponseDto = new ConfirmOrderResponseDto();
		confirmOrderResponseDto.setMessage("order confirmed");
		return confirmOrderResponseDto;
	}
	
	public ConfirmOrderRequestDto getConfirmOrderRequestDto()
	{
		ConfirmOrderRequestDto confirmOrderRequestDto = new ConfirmOrderRequestDto();
		confirmOrderRequestDto.setOrderId(1);
		confirmOrderRequestDto.setStockstatus(StockStatus.C.toString());
		return confirmOrderRequestDto;
	}
	
	public Stocks getStocks()
	{
		Stocks stocks = new Stocks();
		stocks.setAvailableQuantity(20);
		stocks.setStockId(1);
		stocks.setStockPrice(200D);
		return stocks;
	}
	
	public User getUser()
	{
		User user = new User();
		user.setEmailId("gurpreet.gohir@gmail.com");
		user.setUserId(1);
		user.setUserName("Gurpreet Singh");
		return user;
	}
	
	public Orders getOrders()
	{
		Orders orders = new Orders();
		orders.setOrderId(1);
		orders.setStockId(1);
		orders.setStockQuantity(50);
		orders.setUserId(1);
		orders.setTotalPrice(200D);
		orders.setSettlementDate(LocalDate.of(2019, 8, 26).plusDays(2));
		orders.setCreationDate(LocalDate.of(2019, 8, 26));
		return orders;
	}
	
	public OrderDto getOrderDto()
	{
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(1);
		orderDto.setStockId(1);
		orderDto.setStockQuantity(100);
		orderDto.setStockStatus(StockStatus.C.toString());
		orderDto.setUserId(1);
		return orderDto;
	}

	@Before
	public void setup()
	{
		confirmOrderResponseDto = getConfirmOrderResponseDto();
		confirmOrderRequestDto = getConfirmOrderRequestDto();
		stock = getStocks();
		user = getUser();
		order = getOrders();
		orderDto = getOrderDto();
	}
	
	@Test
	public void testConfirmOrder()
	{
		confirmOrderRequestDto = getConfirmOrderRequestDto();
		Mockito.when(ordersRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(order));
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		Mockito.when(stockRepository.save(Mockito.any())).thenReturn(stock);
		Mockito.when(ordersRepository.save(Mockito.any())).thenReturn(order);
		ConfirmOrderResponseDto confirmOrderResponseDto = confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
		assertEquals("Order confirmed", confirmOrderResponseDto.getMessage());
	}
	
	@Test
	public void testConfirmOrder_5()
	{
		confirmOrderRequestDto = getConfirmOrderRequestDto();
		confirmOrderRequestDto.setStockstatus(StockStatus.R.toString());
		Mockito.when(ordersRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(order));
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		Mockito.when(stockRepository.save(Mockito.any())).thenReturn(stock);
		Mockito.when(ordersRepository.save(Mockito.any())).thenReturn(order);
		ConfirmOrderResponseDto confirmOrderResponseDto = confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
		assertEquals("Order rejected", confirmOrderResponseDto.getMessage());
	}
	
	
	@Test(expected = StocksNotFoundException.class)
	public void testConfirmOrder_1()
	{
		Mockito.when(ordersRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(order));
		confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void testConfirmOrder_2()
	{
		confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void testConfirmOrder_3()
	{
		confirmOrderServiceImpl.confirmOrder(confirmOrderRequestDto);
	}
	
}
