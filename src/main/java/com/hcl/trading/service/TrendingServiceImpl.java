package com.hcl.trading.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.TrendingResponseDto;
import com.hcl.trading.exception.OrdersNotFoundException;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.util.TradingConstants;

/**
 * @author DeepikaSivarajan
 *
 */
@Service
public class TrendingServiceImpl implements TrendingService {
	private static Logger logger = LoggerFactory.getLogger(TrendingServiceImpl.class);
	@Autowired
	OrdersRepository ordersRepository;

	/**
	 * This method is intended to list trending stocks based on the count
	 * 
	 * @exception OrdersNotFoundException is used if no orders are present
	 * @return TrendingResponseDto which includes stockId,stockName,count
	 */

	@Override
	public List<TrendingResponseDto> getAllTrendingStocks() {
		List<TrendingResponseDto> ordersList = ordersRepository.getToptrendings();
		if (ordersList.isEmpty()) {
			throw new OrdersNotFoundException(TradingConstants.ORDER_NOT_FOUND);
		}
		logger.info("trending stocks in service");
		return ordersList;
	}
}
