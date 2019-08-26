package com.hcl.trading.service;

import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.dto.OrderResponseDto;

public interface OrderServcie {
	OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
	

}
