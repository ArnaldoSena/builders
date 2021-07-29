package com.platform.usecase;

import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteClient {

	private ClientRepository repository;
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
