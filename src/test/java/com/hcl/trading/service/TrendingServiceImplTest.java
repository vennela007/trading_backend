package com.hcl.trading.service;

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

import com.hcl.trading.dto.TrendingResponseDto;
import com.hcl.trading.exception.OrdersNotFoundException;
import com.hcl.trading.repository.OrdersRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TrendingServiceImplTest {
	@Mock
	OrdersRepository ordersRepository;
	@InjectMocks
	TrendingServiceImpl trendingServiceImpl;
	List<TrendingResponseDto> responseList;
	TrendingResponseDto trendingResponseDto;

	@Before
	public void setUp() {
		responseList = new ArrayList<>();
		trendingResponseDto = new TrendingResponseDto();
		trendingResponseDto.setStockId(1);
		responseList.add(trendingResponseDto);
	}

	@Test
	public void testGetAllTrendingStocks() {
		Mockito.when(ordersRepository.getToptrendings()).thenReturn(responseList);
		List<TrendingResponseDto> ordersList = trendingServiceImpl.getAllTrendingStocks();
		Assert.assertEquals(responseList.get(0).getStockId(), ordersList.get(0).getStockId());

	}

	@Test(expected = OrdersNotFoundException.class)
	public void testGetAllTrendingStocks_1() {
		trendingServiceImpl.getAllTrendingStocks();
	}
}
