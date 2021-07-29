package com.platform.usecase;

import com.platform.domain.entity.Client;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateClient {
	
	private ClientRepository repository;
	
	public Client update(Client client) {
		return repository.update(client);
	}
}
