package com.hcl.trading.exception;

import java.io.Serializable;

public class StocksNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public StocksNotFoundException(String message) {
		super(message);
	}

}
