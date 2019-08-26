package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrendingResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockName;
	private Long count;
}
