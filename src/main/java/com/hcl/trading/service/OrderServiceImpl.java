package com.hcl.trading.service;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.trading.dto.GlobalQuoteDto;
import com.hcl.trading.dto.OrderRequestDto;
import com.hcl.trading.dto.OrderResponseDto;
import com.hcl.trading.entity.Orders;
import com.hcl.trading.entity.StockStatus;
import com.hcl.trading.entity.Stocks;
import com.hcl.trading.entity.User;
import com.hcl.trading.exception.CommonException;
import com.hcl.trading.repository.LatestPriceRepository;
import com.hcl.trading.repository.OrdersRepository;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.repository.UserRepository;
import com.hcl.trading.util.TradingConstants;

/**
 * @author HariPriya
 *
 */
@Service
public class OrderServiceImpl implements OrderServcie {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrdersRepository orderRepository;

	@Autowired
	StockRepository stockRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LatestPriceRepository latestPriceRepository;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 
	 * This method is create the order
	 * 
	 * @param OrderRequestDto is the input request which includes number of
	 *                        quantity, stockId, userId
	 * @return it returns OrderResponseDto object with latest stock price and
	 *         current stock price
	 */

	@Override
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
		LOGGER.info("Enter into order service impl");

		Optional<Stocks> stock = stockRepository.findById(orderRequestDto.getStockId());
		Optional<User> user = userRepository.findById(orderRequestDto.getUserId());

		if (!stock.isPresent())
			throw new CommonException(TradingConstants.ERROR_STOCK_NOT_FOUND);
		if (!user.isPresent())
			throw new CommonException(TradingConstants.ERROR_USER_NOT_FOUND);
		if (orderRequestDto.getStockQuantity() >= 100)
			throw new CommonException(TradingConstants.ERROR_QUANTITY);
		Double brokeragePercent = Double.valueOf(stock.get().getBrokerageAmount() / 100d);
		Double brokerageAmount = stock.get().getStockPrice() * orderRequestDto.getStockQuantity() + brokeragePercent;
		Double totalPrice = stock.get().getStockPrice() * orderRequestDto.getStockQuantity() + brokerageAmount;

		Orders orders = Orders.builder().stockId(stock.get().getStockId())
				.stockQuantity(orderRequestDto.getStockQuantity()).totalPrice(totalPrice)
				.stockStatus(StockStatus.P.toString()).userId(orderRequestDto.getUserId()).build();
		orderRepository.save(orders);
		ResponseEntity<GlobalQuoteDto> latest = latestStockPrice(stock.get().getStockName());
		return new OrderResponseDto(orders.getOrderId(), stock.get().getStockPrice(),
				latest.getBody().getGlobalQuote().getPrice());
	}

	public ResponseEntity<GlobalQuoteDto> latestStockPrice(String stockName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);

		return new ResponseEntity<GlobalQuoteDto>(
				restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockName
						+ "&apikey=CQA8OG03A7GVM5ZU", HttpMethod.GET, entity, GlobalQuoteDto.class).getBody(),
				HttpStatus.OK);

	}

}
