package com.hcl.trading.exception;

import java.io.Serializable;

public class OrdersNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public OrdersNotFoundException(String message) {
		super(message);

	}

}
