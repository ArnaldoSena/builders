package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.adapter.id_generator.UuidGenerator;
import com.platform.domain.entity.Client;
import com.platform.usecase.erros.Erro;
import com.platform.usecase.port.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@AllArgsConstructor
public class CreateClientService {
	
	@Autowired
	private final ClientRepository repository;
	
	public Client create(final Client client){
		if(client == null) {
			log.error(Erro.CLIENTE_NULO);
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
