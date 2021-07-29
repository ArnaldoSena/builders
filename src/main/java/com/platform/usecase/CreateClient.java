package com.platform.usecase;

import com.platform.domain.entity.Client;
import com.platform.domain.exception.ClientAlreadyExistsException;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateClient {
	
	private final ClientRepository repository;
	
	public Client create(final Client client) throws ClientAlreadyExistsException {
		if(repository.findByEmail(client.getEmail()).isPresent()) {
			throw new ClientAlreadyExistsException(client.getEmail());
		}
		var newClient = Client.builder()
				.id(1l)
				.email(client.getEmail())
				.passWord(client.getPassWord())
				.birthDate(client.getBirthDate())
				.firstName(client.getFirstName())
				.lastName(client.getLastName())
				.build();
		return repository.create(newClient);
	}
}
