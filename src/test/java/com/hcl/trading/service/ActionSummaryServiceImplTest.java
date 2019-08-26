package com.hcl.trading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trading.dto.ActionSummaryResponseDto;
import com.hcl.trading.entity.Orders;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.exception.OrdersNotFoundException;
import com.hcl.trading.exception.StocksNotFoundException;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.repository.StockRepository;
/**
 * 
 * @author DeepikaSivarajan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ActionSummaryServiceImplTest {
	@Mock
	StockRepository stockRepository;
	@Mock
	OrdersRepository ordersRepository;
	@InjectMocks
	ActionSummaryServiceImpl actionSummaryServiceImpl;

	List<Orders> ordersList;
	Orders orders;
	Stocks stocks;
	ActionSummaryResponseDto actionSummaryResponseDto;
	List<ActionSummaryResponseDto> responseList;

	@Before
	public void setUp() {
		ordersList = new ArrayList<>();
		orders = new Orders();
		stocks = new Stocks();
		actionSummaryResponseDto = new ActionSummaryResponseDto();
		responseList = new ArrayList<>();
		orders.setStockId(1);
		orders.setUserId(1);
		ordersList.add(orders);
		stocks.setStockId(1);
		actionSummaryResponseDto.setStockId(1);
		responseList.add(actionSummaryResponseDto);

	}

	@Test
	public void testGetAllActionSummary() {
		Mockito.when(ordersRepository.findByUserId(Mockito.anyInt())).thenReturn(ordersList);
		Mockito.when(stockRepository.findById(1)).thenReturn(Optional.of(stocks));
		List<ActionSummaryResponseDto> response = actionSummaryServiceImpl.getAllActionSummary(1);
		Assert.assertEquals(responseList.get(0).getStockId(), response.get(0).getStockId());

	}

	@Test(expected = OrdersNotFoundException.class)
	public void testGetAllActionSummaryNegative_1() {
		actionSummaryServiceImpl.getAllActionSummary(Mockito.anyInt());
	}

	@Test(expected = StocksNotFoundException.class)
	public void testGetAllActionSummaryNegative_2() {
		Mockito.when(ordersRepository.findByUserId(Mockito.anyInt())).thenReturn(ordersList);
		actionSummaryServiceImpl.getAllActionSummary(Mockito.anyInt());
	}
}
