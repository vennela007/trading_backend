/**
 * 
 */
package com.hcl.trading.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.trading.dto.OrderStatusRequestDto;
import com.hcl.trading.dto.OrderStatusResponseDto;
import com.hcl.trading.entity.Stocks;

/**
 * @author Gurpreet Singh
 * This is the service class for the order status.
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService{
	
	

	/**
	 * This method is use to confirm or reject the order.
	 */
	public OrderStatusResponseDto confirmOrder(OrderStatusRequestDto orderStatusRequestDto) {
//		Optional<Stocks> stocks = 
		
		return null;
	}

}
