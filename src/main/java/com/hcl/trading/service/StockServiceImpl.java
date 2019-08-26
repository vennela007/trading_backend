package com.hcl.trading.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.trading.dto.StockDto;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.exception.StockNotFoundException;
import com.hcl.trading.repository.StockRepository;
/**
 * @author Venkat
 *
 */
@Service
public class StockServiceImpl implements StockService{
@Autowired StockRepository stockRepository;
private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
	@Override
	public List<StockDto> getAllAvailableStocks() {
		/**
		 * This method is used to get all available Stocks
		 * 
		 * 
		 * @return StockDto is the output which includes stockId, stockName,stockPrice,
		 *  stockExchangeName, stockQuantity, brokerageAmount
		*/
		
		logger.info("inside the StockServiceImpl getAllAvailableStocks method");
		List<StockDto> stockList = new ArrayList<>();
		List<Stocks> stocksList = stockRepository.findAll();
		if (stocksList.isEmpty())
			throw new StockNotFoundException("Stock not found");
		stocksList.stream().forEach(c -> {
			StockDto response = new StockDto();
			BeanUtils.copyProperties(c, response);

			stockList.add(response);
		});
		return stockList;
	}
}
