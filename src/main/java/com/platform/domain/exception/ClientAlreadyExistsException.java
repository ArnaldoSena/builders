package com.platform.domain.exception;

import lombok.Builder;

public class ClientAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Builder
	public ClientAlreadyExistsException(String email) {
		super(email);
	}
}
