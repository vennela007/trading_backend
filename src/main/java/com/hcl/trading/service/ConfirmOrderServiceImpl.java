/**
 * 
 */
package com.hcl.trading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.ConfirmOrderRequestDto;
import com.hcl.trading.dto.ConfirmOrderResponseDto;
import com.hcl.trading.entity.Orders;
import com.hcl.trading.entity.StockStatus;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.entity.User;
import com.hcl.trading.exception.OrderNotFoundException;
import com.hcl.trading.exception.StocksNotFoundException;
import com.hcl.trading.exception.UserNotFoundException;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.repository.UserRepository;
import com.hcl.trading.util.EmailSender;
import com.hcl.trading.util.TradingConstants;

/**
 * @author Gurpreet Singh
 * This is the service class for the order status.
 *
 */
@Service
public class ConfirmOrderServiceImpl implements ConfirmOrderService{
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailSender emailSender;

	ConfirmOrderResponseDto confirmOrderResponseDto;
	/**
	 * This method is use to confirm or reject the order.
	 * @param ConfirmOrderRequestDto is the input which includes orderId and stockStatus
	 * @return ConfirmOrderResponseDto is the output which includes message with status code
	 * @exception StocksNotFoundException if user not found, stock not found, order not found.
	 */
	public ConfirmOrderResponseDto confirmOrder(ConfirmOrderRequestDto confirmOrderRequestDto) {
		Optional<Orders> order = ordersRepository.findById(confirmOrderRequestDto.getOrderId());
		if(!order.isPresent())
			throw new OrderNotFoundException(TradingConstants.ERROR_INVALID_ORDERS);
		Optional<Stocks> stocks = stockRepository.findById(order.get().getStockId());
		if(!stocks.isPresent())
			throw new StocksNotFoundException(TradingConstants.ERROR_INVALID_STOCKS);
		Optional<User> user = userRepository.findById(order.get().getUserId());
		if(!user.isPresent())
			throw new UserNotFoundException(TradingConstants.ERROR_INVALID_USER);
		
		if(confirmOrderRequestDto.getStockstatus().equalsIgnoreCase(StockStatus.C.toString()))
		{
			order.get().setStockStatus(StockStatus.C.toString());
			order.get().setSettlementDate(order.get().getCreationDate().plusDays(2));
			Integer quantity = stocks.get().getAvailableQuantity()-order.get().getStockQuantity();
			stocks.get().setAvailableQuantity(quantity);
			 confirmOrderResponseDto = new ConfirmOrderResponseDto();
			confirmOrderResponseDto.setMessage("Order confirmed");
		}
		else if (confirmOrderRequestDto.getStockstatus().equalsIgnoreCase(StockStatus.R.toString()))
		{
			order.get().setStockStatus(StockStatus.R.toString());
			order.get().setSettlementDate(order.get().getCreationDate());
			confirmOrderResponseDto = new ConfirmOrderResponseDto();
			confirmOrderResponseDto.setMessage("Order rejected");
		} 
		
		stockRepository.save(stocks.get());
		ordersRepository.save(order.get());
		return confirmOrderResponseDto;
	}

}
