/**
 * 
 */
package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gurpreet Singh
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmOrderRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	private String stockstatus;

}
