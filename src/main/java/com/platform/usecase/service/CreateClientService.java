package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.adapter.id_generator.UuidGenerator;
import com.platform.domain.entity.Client;
import com.platform.domain.exception.ClientAlreadyExistsException;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CreateClientService {
	
	@Autowired
	private final ClientRepository repository;
	
	public Client create(final Client client) throws ClientAlreadyExistsException {
		if(repository.findByEmail(client.getEmail()).isPresent()) {
			throw new ClientAlreadyExistsException(client.getEmail());
		}
		var newClient = Client.builder()
				.id(UuidGenerator.createId())
				.email(client.getEmail())
				.passWord(client.getPassWord())
				.birthDate(client.getBirthDate())
				.firstName(client.getFirstName())
				.lastName(client.getLastName())
				.build();
		return repository.create(newClient);
	}
}
