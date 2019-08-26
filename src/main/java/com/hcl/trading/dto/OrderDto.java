/**
 * 
 */
package com.hcl.trading.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author user1
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer stockId;
	private Integer stockQuantity;
	private Double totalPrice;
	@CreationTimestamp
	private LocalDate creationDate;
	@CreationTimestamp
	private LocalDate settlementDate;
	private String stockStatus;
	private Integer userId;
}
