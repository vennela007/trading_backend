package com.hcl.trading.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.trading.dto.StockDto;
@Service
public interface StockService {

	public List<StockDto> getAllAvailableStocks();

	
}
