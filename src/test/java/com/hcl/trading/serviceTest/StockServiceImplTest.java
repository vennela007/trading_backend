package com.hcl.trading.serviceTest;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.trading.dto.StockDto;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.exception.StockNotFoundException;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.service.StockServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {
private static final Logger logger = LoggerFactory.getLogger(StockServiceImplTest.class);
	@Mock StockRepository stockRepository;
	@InjectMocks StockServiceImpl StockServiceImpl;
	List<Stocks> stockList;
	Stocks stocks;
	@Before
	public void setUp() {
		stockList = new ArrayList<>();
		stocks = new Stocks();
		stocks.setStockName("INFY");
		stocks.setAvailableQuantity(3455);
		stocks.setBrokerageAmount(2);
		stocks.setStockId(3);
		stocks.setStockPrice(455.9);
		stockList.add(stocks);
	}
	@Test
	public void getAllStocksTest(){
		logger.info("inside the getAllStocksTest method");
		Mockito.when(stockRepository.findAll()).thenReturn(stockList);
		List<StockDto> response = StockServiceImpl.getAllAvailableStocks();	
		Assert.assertEquals(stocks.getStockName(), response.get(0).getStockName());
	}
	@Test(expected=StockNotFoundException.class)
	public void getAllMoviesTest_1() {
		StockServiceImpl.getAllAvailableStocks();
	}
}
