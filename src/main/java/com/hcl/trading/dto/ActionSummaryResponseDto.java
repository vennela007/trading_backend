package com.hcl.trading.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionSummaryResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockExchangeName;
	private String stockName;
	private Integer stockQuantity;
	private Double totalPrice;
	private LocalDate creationDate;
	private LocalDate settlementDate;
	private String stockStatus;
}
