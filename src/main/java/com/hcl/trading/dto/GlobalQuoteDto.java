package com.hcl.trading.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalQuoteDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Global Quote")
	private LatestStockPriceDto globalQuote;

}
