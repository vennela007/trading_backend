/**
 * 
 */
package com.hcl.trading.service;

import org.springframework.stereotype.Service;

import com.hcl.trading.dto.OrderStatusRequestDto;
import com.hcl.trading.dto.OrderStatusResponseDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface OrderStatusService {
	
	public OrderStatusResponseDto confirmOrder(OrderStatusRequestDto orderStatusRequestDto);

}
