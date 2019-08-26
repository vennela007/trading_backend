package com.hcl.trading.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LatestStockPriceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("01. symbol")
	private String symbol;
	
	@JsonProperty("02. open")
	private Double open;
	
	@JsonProperty("03. high")
	private Double high;
	
	@JsonProperty("04. low")
	private Double low;
	
	@JsonProperty("05. price")
	private Double price;
	
	@JsonProperty("06. volume")
	private Integer volume;
	
	@JsonProperty("07. latest trading day")
	private LocalDate latestTradingDay;
	
	@JsonProperty("08. previous close")
	private Double close;
	
	@JsonProperty("09. change")
	private Double change;
	
	@JsonProperty("10. change percent")
	private String percent;
	

}
