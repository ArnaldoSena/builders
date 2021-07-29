package com.platform.domain.exception;

import lombok.Builder;

public class ClientNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Builder
	public ClientNotFound(String message) {
		super(message);
	}
}
