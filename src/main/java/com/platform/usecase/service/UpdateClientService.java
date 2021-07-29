package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.domain.entity.Client;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UpdateClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client update(final Client client) {
		return repository.update(client);
	}
	
}
