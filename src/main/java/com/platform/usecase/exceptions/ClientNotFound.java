package com.platform.usecase.exceptions;

import lombok.Builder;

public class ClientNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Builder
	public ClientNotFound(String message) {
		super(message);
	}
}
