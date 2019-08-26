package com.hcl.trading.service;

import java.util.List;

import com.hcl.trading.dto.TrendingResponseDto;

public interface TrendingService {

	List<TrendingResponseDto> getAllTrendingStocks();

}
