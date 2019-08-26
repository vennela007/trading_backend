/**
 * 
 */
package com.hcl.trading.service;

import org.springframework.stereotype.Service;

import com.hcl.trading.dto.ConfirmOrderRequestDto;
import com.hcl.trading.dto.ConfirmOrderResponseDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface ConfirmOrderService {
	
	public ConfirmOrderResponseDto confirmOrder(ConfirmOrderRequestDto orderStatusRequestDto);

}
