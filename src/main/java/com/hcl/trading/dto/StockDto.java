package com.hcl.trading.dto;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockExchangeName;
	private String stockName;
	private Integer availableQuantity;
	private Double stockPrice;
	private Integer brokerageAmount;

}
