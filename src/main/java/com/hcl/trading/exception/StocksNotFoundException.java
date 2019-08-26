/**
 * 
 */
package com.hcl.trading.exception;

/**
 * @author Gurpreet singh
 *
 */
public class StocksNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StocksNotFoundException(String message) {
		super(message);
	}
	
}
